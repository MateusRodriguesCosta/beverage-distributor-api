package com.beverage_app.beverage_distributor_api.services;

import com.beverage_app.beverage_distributor_api.dtos.ItemPedidoDTO;
import com.beverage_app.beverage_distributor_api.dtos.pedido_cliente.PedidoClienteRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.pedido_cliente.PedidoClienteResponseDTO;
import com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor.PedidoFornecedorRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor.PedidoFornecedorResponseDTO;
import com.beverage_app.beverage_distributor_api.exceptions.FornecedorServiceUnavailableException;
import com.beverage_app.beverage_distributor_api.exceptions.PedidoQuantidadeInsuficienteException;
import com.beverage_app.beverage_distributor_api.exceptions.RevendaNotFoundException;
import com.beverage_app.beverage_distributor_api.mappers.PedidoClienteMapper;
import com.beverage_app.beverage_distributor_api.models.PedidoCliente;
import com.beverage_app.beverage_distributor_api.models.PedidoFornecedorPendente;
import com.beverage_app.beverage_distributor_api.repositories.PedidoFornecedorPendenteRepository;
import com.beverage_app.beverage_distributor_api.repositories.PedidoRepository;
import com.beverage_app.beverage_distributor_api.repositories.RevendaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoClienteMapper pedidoClienteMapper;
    private final RevendaRepository revendaRepository;
    private final PedidoFornecedorPendenteRepository pedidoFornecedorPendenteRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoClienteMapper pedidoClienteMapper,
                         RestTemplate restTemplate,
                         RevendaRepository revendaRepository,
                         PedidoFornecedorPendenteRepository pedidoFornecedorPendenteRepository,
                         ObjectMapper objectMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoClienteMapper = pedidoClienteMapper;
        this.revendaRepository = revendaRepository;
        this.pedidoFornecedorPendenteRepository = pedidoFornecedorPendenteRepository;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public PedidoClienteResponseDTO createPedidoCliente(PedidoClienteRequestDTO pedidoClienteRequestDTO) {
        PedidoCliente pedidoCliente = pedidoClienteMapper.toPedidoCliente(pedidoClienteRequestDTO);
        PedidoCliente savedPedidoCliente = pedidoRepository.save(pedidoCliente);
        return pedidoClienteMapper.toPedidoClienteResponseDTO(savedPedidoCliente);
    }

    public PedidoFornecedorResponseDTO createPedidoFornecedor(PedidoFornecedorRequestDTO requestDTO) {
        revendaRepository.findByCnpj(requestDTO.getRevenda().getCnpj())
                .orElseThrow(() -> new RevendaNotFoundException("Revenda não encontrada"));

        int totalPedido = requestDTO.getItens().stream()
                .mapToInt(ItemPedidoDTO::getQuantidade)
                .sum();

        if (totalPedido < 1000) {
            throw new PedidoQuantidadeInsuficienteException("O pedido não atinge o mínimo de 1000 unidades.");
        }

        return sendPedidoToFornecedor(requestDTO);
    }

    @Retryable(
            retryFor = {RestClientException.class},
            backoff = @Backoff(delay = 2000)
    )
    public PedidoFornecedorResponseDTO sendPedidoToFornecedor(PedidoFornecedorRequestDTO requestDTO) {
        return restTemplate.postForObject(
                "http://api-fornecedor/pedidos",
                requestDTO,
                PedidoFornecedorResponseDTO.class
        );
    }

    @Recover
    public PedidoFornecedorResponseDTO recover(RestClientException ex, PedidoFornecedorRequestDTO requestDTO) {
        PedidoFornecedorPendente pedidoPendente = new PedidoFornecedorPendente();
        try {
            String payload = objectMapper.writeValueAsString(requestDTO);
            pedidoPendente.setPayload(payload);
        } catch (JsonProcessingException e) {
            pedidoPendente.setPayload("Error serializing payload: " + e.getMessage());
        }
        pedidoPendente.setDataCriacao(LocalDateTime.now());
        pedidoPendente.setStatus("PENDING");

        pedidoFornecedorPendenteRepository.save(pedidoPendente);
        throw new FornecedorServiceUnavailableException("Serviço do fornecedor indisponível. Pedido salvo para reprocessamento.", ex);
    }
}
