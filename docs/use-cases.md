# API Use Cases

### ✅ Create Revenda

- Create a new revenda with required fields:
  - CNPJ, Razão Social, Nome Fantasia, and Email

### ✅ Create Pedido Cliente

- Create a new pedido cliente.
- It must return cliente identification.
- It must return the product list and the amount.
- There is no minimum amount requirement.

### ✅ Create Pedido Fornecedor

- Create a new pedido fornecedor.
- It must have more than a thousand items.
- It must return the pedido fornecedor id.
- It calls an unstable endpoint that needs fallback logic.