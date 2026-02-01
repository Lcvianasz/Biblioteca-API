📚 Biblioteca API

API REST desenvolvida em Java com Spring Boot para gerenciamento de uma biblioteca, permitindo cadastro, consulta, atualização e remoção de livros.
O projeto utiliza Spring Security com JWT para autenticação, MySQL como banco de dados e segue boas práticas de arquitetura com DTOs, Services e Repositories.

🚀 Tecnologias Utilizadas

Java 17

Spring Boot

Spring Web

Spring Data JPA

Spring Security

JWT (JSON Web Token)

MySQL

Lombok

Maven

Postman (para testes)

🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas:

controller → dto → service → repository → database


Principais pacotes:

controller – Endpoints REST

dto – Objetos de transferência de dados (Request/Response)

model – Entidades JPA

repository – Repositórios Spring Data

security – Configuração de segurança, JWT e autenticação

service – Regras de negócio

🔐 Autenticação e Segurança

A API utiliza Spring Security + JWT.

Login gera um token JWT

O token deve ser enviado no header Authorization

Endpoints protegidos exigem autenticação

Header de autenticação:
Authorization: Bearer SEU_TOKEN_AQUI

🔑 Endpoint de Login
POST /api/auth/login

Request Body:

{
  "username": "admin",
  "password": "123456"
}


Response:

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

📘 Endpoints de Livros
📌 Listar livros (com paginação)
GET /api/livros?page=0&size=5

📌 Buscar livro por ID
GET /api/livros/{id}

📌 Criar livro
POST /api/livros


Request Body:

{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008,
  "isbn": "9780132350884"
}

📌 Atualizar livro
PUT /api/livros/{id}

📌 Deletar livro
DELETE /api/livros/{id}

📄 Paginação

A listagem de livros utiliza Pageable do Spring Data.

Exemplo:

GET /api/livros?page=0&size=10&sort=titulo,asc

🔐 Configuração de Ambiente

⚠️ Dados sensíveis NÃO são versionados no GitHub.

O projeto utiliza variáveis de ambiente.

Variáveis necessárias:

JWT_SECRET

DB_USER

DB_PASSWORD

Exemplo (application-example.properties):
spring.application.name=biblioteca

jwt.secret=CHANGE_ME
jwt.expiration=3600000

spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=DB_USER
spring.datasource.password=DB_PASSWORD

🧪 Testes

Os testes da API foram realizados utilizando o Postman, validando:

Autenticação JWT

Controle de acesso (403 Forbidden)

CRUD completo de livros

Paginação

🗄️ Banco de Dados

Tabela de usuários:

CREATE TABLE usuarios (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);


As senhas são armazenadas com BCrypt.

📦 Como Executar o Projeto
git clone https://github.com/Lcvianasz/Biblioteca-API.git
cd Biblioteca-API
mvn spring-boot:run

🛠️ Melhorias Futuras

Cadastro de usuários

Controle de permissões (ADMIN / USER)

Swagger / OpenAPI

Testes automatizados (JUnit + Mockito)

Dockerização do projeto

Deploy em nuvem (Render / Railway)

📬 Entre em Contato

Autor: Lucas Viana

GitHub: https://github.com/Lcvianasz

LinkedIn: linkedin.com/in/lucas-viana-souza
