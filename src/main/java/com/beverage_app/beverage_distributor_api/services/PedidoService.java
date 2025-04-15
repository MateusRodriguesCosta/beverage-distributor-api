package com.beverage_app.beverage_distributor_api.services;

import com.beverage_app.beverage_distributor_api.dtos.ItemPedidoDTO;
import com.beverage_app.beverage_distributor_api.dtos.PedidoClienteDTO;
import com.beverage_app.beverage_distributor_api.dtos.PedidoFornecedorRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.PedidoFornecedorResponseDTO;
import com.beverage_app.beverage_distributor_api.exceptions.FornecedorServiceUnavailableException;
import com.beverage_app.beverage_distributor_api.exceptions.PedidoQuantidadeInsuficienteException;
import com.beverage_app.beverage_distributor_api.exceptions.RevendaNotFoundException;
import com.beverage_app.beverage_distributor_api.mappers.PedidoClienteMapper;
import com.beverage_app.beverage_distributor_api.models.PedidoCliente;
import com.beverage_app.beverage_distributor_api.repositories.PedidoRepository;
import com.beverage_app.beverage_distributor_api.repositories.RevendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoClienteMapper pedidoClienteMapper;
    private final RevendaRepository revendaRepository;
    private final RestTemplate restTemplate;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoClienteMapper pedidoClienteMapper,
                         RestTemplate restTemplate,
                         RevendaRepository revendaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoClienteMapper = pedidoClienteMapper;
        this.revendaRepository = revendaRepository;
        this.restTemplate = restTemplate;
    }

    public PedidoClienteDTO createPedidoCliente(PedidoClienteDTO pedidoClienteDTO) {
        PedidoCliente pedidoCliente = pedidoClienteMapper.toPedidoCliente(pedidoClienteDTO);
        PedidoCliente savedPedidoCliente = pedidoRepository.save(pedidoCliente);
        return pedidoClienteMapper.toPedidoClienteDTO(savedPedidoCliente);
    }

    public PedidoFornecedorResponseDTO createPedidoFornecedor(PedidoFornecedorRequestDTO requestDTO) {
        revendaRepository.findByCnpj(requestDTO.getRevenda().getCnpj())
                .orElseThrow(() -> new RevendaNotFoundException("Revenda não encontrada"));

        int totalPedido = requestDTO.getPedidoFornecedor().getItens().stream()
                .mapToInt(ItemPedidoDTO::getQuantidade)
                .sum();

        if (totalPedido < 1000) {
            throw new PedidoQuantidadeInsuficienteException("O pedido não atinge o mínimo de 1000 unidades.");
        }

        try {
            return restTemplate.postForObject(
                    "http://api-fornecedor/pedidos",
                    requestDTO,
                    PedidoFornecedorResponseDTO.class
            );
        } catch (RestClientException ex) {
            throw new FornecedorServiceUnavailableException("Serviço da AMBEV indisponível.", ex);
        }
    }
}
