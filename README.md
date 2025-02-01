# Projeto Java Spring Web - E-commerce Simples

Este projeto é um sistema básico de e-commerce desenvolvido em Java com Spring Boot. Ele inclui funcionalidades como gerenciamento de usuários, pedidos, produtos, categorias, pagamentos e itens de pedido. O projeto foi desenvolvido para praticar conceitos de Spring Boot, JPA, H2 Database, e relacionamentos entre entidades.

## Funcionalidades

- **Usuário (User)**: CRUD completo (Create, Read, Update, Delete).
- **Pedido (Order)**: Associado a um usuário e a um pagamento, com status de pedido (OrderStatus) definido por um ENUM.
- **Produto (Product)**: Associado a uma categoria e a itens de pedido.
- **Categoria (Category)**: Categorias de produtos.
- **Item de Pedido (OrderItem)**: Relacionamento muitos-para-muitos entre Pedido e Produto, com chave composta.
- **Pagamento (Payment)**: Relacionamento um-para-um com Pedido.
- **Métodos de cálculo**: Subtotal para Itens de pedido e total para pedidos.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (para ambiente de teste)
- **Postgresql** (para ambiente de produção)
- **Maven** (gerenciamento de dependências)
- **Postman** (para testes de API)

## Estrutura do Projeto

O projeto está organizado nas seguintes camadas:

- **Entities**: Contém as classes de entidade (`User`, `Order`, `OrderItem`, `Product`, `Category`, `Payment`).
- **Repositories**: Interfaces que estendem `JpaRepository` para acesso ao banco de dados.
- **Services**: Camada de serviço que contém a lógica de negócio.
- **Controllers**: Controladores REST que expõem os endpoints da API.
- **Enums**: Definição de `OrderStatus`.
- **Exceptions**: Tratamento de exceções personalizadas.

