# JWT API – Spring Security & JWT

API desenvolvida para fins de estudo sobre autenticação e autorização utilizando Spring Boot, Spring Security e JSON Web Tokens (JWT).

## 📚 Referência de Estudo

Este projeto foi desenvolvido como parte dos estudos no curso **Protegendo sua API RESTful com Spring Security e JWT** da Rocketseat.

A implementação original utilizava **Java 11**.  
Este repositório contém uma versão refatorada e adaptada para **Java 17**, incluindo:

- Ajustes em APIs atualizadas
- Melhor separação de responsabilidades
- Pequenas melhorias estruturais

Repositório original do professor:  
👉 https://github.com/pedrohenriquelacombe/spring-rest-jwt-example

---

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 4.0.2**
* **Spring Security** – Autenticação e Autorização
* **Java-JWT (Auth0)** – Geração e validação de tokens
* **Spring Data JPA** – Persistência de dados
* **H2 Database** – Banco de dados em memória para testes
* **Lombok** – Redução de boilerplate
* **Jackson Databind** – Manipulação de JSON

---

## 🛠️ Estrutura do Projeto

O projeto segue uma arquitetura em camadas organizada por pacotes:

### Controller
Responsável por expor os endpoints da API e receber as requisições HTTP.

### Service
Contém a lógica de negócio da aplicação.

- `UserService` → Gerenciamento de usuários e implementação do `UserDetailsService` para integração com o Spring Security.
- `RoleService` → Gerenciamento de perfis e permissões.

### Repository
Interfaces que estendem o Spring Data JPA para acesso ao banco de dados.

### Model
Entidades `User` e `Role` que representam a estrutura de dados e permissões.

### Security
Centraliza a configuração do Spring Security e a lógica de autenticação e autorização baseada em JWT.

### Filters
Inclui `AuthenticationFilter` (login) e `AuthorizationFilter` (validação do JWT em cada requisição).

---

## 🔑 Fluxo de Autenticação

A API utiliza o prefixo global `/api` configurado no `application.properties`.

### 1. Login

O usuário envia **email** e **password** para:

```
POST /api/auth0/token
```

### 2. Geração do Token

O `AuthenticationFilter` valida as credenciais e, em caso de sucesso:

* Gera um **JWT**
* Assinado com **HMAC256**
* Validade de **10 minutos**

### 3. Autorização

Para acessar rotas protegidas, o cliente deve enviar no header:

```
Authorization: Bearer <seu_token_aqui>
```

---

## 📋 Endpoints e Permissões

| Método | Endpoint         | Permissão Necessária               | Descrição                   |
| ------ | ---------------- | ---------------------------------- | --------------------------- |
| POST   | /api/auth0/token | Pública                            | Realiza login e retorna JWT |
| GET    | /api/roles       | ROLE_MASTER                        | Lista perfis de acesso      |
| POST   | /api/users       | ROLE_MASTER, ROLE_ADMIN            | Cria novo usuário           |
| GET    | /api/users       | ROLE_MASTER, ROLE_ADMIN, ROLE_USER | Lista usuários              |

---

## ⚙️ Como Executar

1. Clone o repositório
2. Tenha o **Maven** instalado ou utilize o `mvnw`
3. Execute:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```
http://localhost:8080/api
```

## 📌 Observações

- As senhas são criptografadas utilizando BCrypt antes de serem armazenadas no banco.
- No início da aplicação, o sistema é populado automaticamente com usuários de teste através da classe `JwtApiApplication`.

---

## 📝 Licença
Este projeto está sob a licença MIT.

Veja o arquivo [LICENSE](LICENSE) para mais detalhes.



