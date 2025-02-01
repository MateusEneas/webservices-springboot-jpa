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
- **Postgresql** (para ambiente de desenvolvimento)
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

## Aprendizados

Com este projeto, aprendi e pratiquei os sequintes conceitos e técnicas:

- **Spring Boot**:
  - Configuração de um projeto Spring Boot
  - Uso de @RestController para criar endpoints REST
  - Injeção de dependências com @Autowired
  
- **Spring Data JPA**:
  - Crição de entidades e mapeamento de relacionamentos (@OneToMany, @ManyToOne, @ManyToMany, @OneToOne).
  - Uso de @JoinTable para relacionamentos muitos para muitos.
  - Definição de chaves primárias compostas com @Embeddable e @EmbeddedId.
    
- **Banco de Dados**:
  - Configuração e uso do H2 Database para teste.
  - Configuração e uso do PostgreSQL para desenvolvimento
  - Uso de múltiplos perfis (application-test.properties e application-dev.properties)
    
- **Tratamento de exceções**:
  - Criação de exceções personalizadas
  - Uso de @ExceptionHandler para tratar exceções globalmente
    
- **Testes de API**:
  - Uso do Postman para testar endpoints REST
  - Verificação de respostas HTTP
    
- **Lógica de Negócio**:
  - Implementação de métodos para cálculo de subtotal e total de pedidos
  - Gerenciamento de estados de pedidos com OrderStatus
 
- **Boas Práticas**:
  - Organização do projeto em camadas (entities, repositories, services, controllers)
 
   ### Exemplos de Requisições

   - **Criar Usuário**:
     ```http
     POST /users

     {
       "name": "Seu menino",
       "email": "menino@teste.com",
       "phone": "99999999",
       "password": "99999"
     }
     ```

   - **Listar Pedidos**:
     ```http
     GET /orders
     ```

   - **Listar Produtos**:
     ```http
     GET /products
     ```
     
   - **Deletar Usuário**:
     ```http
     DELETE /users/id
    
   - **Atualizar Usuario**:
     ```http
     PUT /user/id
       
     {
       "name": "novo nome",
       "email": "novoemail@teste.com",
       "phone": "novo numero"
     }
     ```

   ### Imagens do Postman

   **Criar Usuário**
   ![Criar Usuário](https://github.com/user-attachments/assets/22afc436-ebb7-483f-abe6-b0deea5d7588)
   **Deletar Usuário**
   ![Deletar Usuário](https://github.com/user-attachments/assets/7b52b839-f21d-4ad5-aa74-3973cdc4646d)
   **Atualizar Usuário**
   ![Atualizar Usuário](https://github.com/user-attachments/assets/9b48f540-900d-4d26-9fd2-21b597319a1d)
   **Deletar Usuário não existente**
   ![Tentar deletar usuário que não existe](https://github.com/user-attachments/assets/3b7a2cc7-58a1-49f5-8423-5b832112e46f)
   **Retornar Usuário não existente**
   ![Retornar usuário que não existe](https://github.com/user-attachments/assets/af06fee6-c030-4bd0-8b38-b755559c6c11)  

   ### Imagens do Banco de Dados

   **Todas as tabelas**
   ![Todas as tabelas](https://github.com/user-attachments/assets/0dc78bfa-a050-46df-b3a8-0af4668f10b2)
  
   **Listando os usuários**
   ![Lista de Usuários](https://github.com/user-attachments/assets/6eac598d-1fb8-4520-aa2f-83e9b8cda403)
  
   **Listando os pedidos**
   ![Lista de pedidos](https://github.com/user-attachments/assets/a9d0a153-3018-4859-a4d4-6975abb3a30f)
  
   **Listando Itens do Pedido**
   ![Itens do pedido](https://github.com/user-attachments/assets/456b8014-abe7-4039-8b43-fc7b73611711)
