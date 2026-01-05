📚 Biblioteca API

API desenvolvida com Spring Boot e MySQL para o gerenciamento de uma biblioteca.
O sistema permite cadastrar, listar, buscar e remover livros, oferecendo uma base sólida para futuras expansões, como cadastro de autores, usuários e controle de empréstimos.

🧩 Tecnologias Utilizadas

☕ Java 17+

🚀 Spring Boot (Web, Data JPA)

🗄️ MySQL

🧰 Maven

🧪 Postman / Insomnia (para testes)

🧱 Spring DevTools (para hot reload em desenvolvimento)

⚙️ Configuração do Projeto
1️⃣ Criar o projeto no Spring Initializr

Configurações:

Project: Maven Project

Language: Java

Spring Boot: 3.x

Packaging: Jar

Java: 17

Dependências:

Spring Web

Spring Data JPA

MySQL Driver

Spring Boot DevTools

Baixe o arquivo .zip e extraia em sua máquina.

🧠 Estrutura de Pastas
biblioteca/
├── src/
│   ├── main/
│   │   ├── java/com/example/biblioteca/
│   │   │   ├── controller/     -> Controladores REST
│   │   │   ├── model/          -> Entidades (Livros, Autores, etc.)
│   │   │   ├── repository/     -> Interfaces JPA
│   │   │   └── service/        -> Regras de negócio
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/ e templates/ (opcional)
└── pom.xml

🧾 Exemplo de Entidade: Livro.java
package com.example.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String isbn;

    // Getters e Setters
}

💾 Configuração do Banco de Dados (MySQL)

No arquivo src/main/resources/application.properties, adicione:

spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


⚠️ Certifique-se de criar o banco antes de rodar o projeto:

CREATE DATABASE biblioteca;

🧩 Controller: LivroController.java
package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroService.deletar(id);
    }
}

🧪 Testando com Postman
1️⃣ Listar livros

GET → http://localhost:8080/livros

2️⃣ Buscar por ID

GET → http://localhost:8080/livros/1

3️⃣ Cadastrar livro

POST → http://localhost:8080/livros
Body (JSON):

{
  "titulo": "O Senhor dos Anéis",
  "autor": "J.R.R. Tolkien",
  "anoPublicacao": 1954,
  "isbn": "978-8533613379"
}

4️⃣ Deletar livro

DELETE → http://localhost:8080/livros/1

🚀 Executando o Projeto

No terminal (na pasta do projeto):

mvn spring-boot:run


A API estará disponível em:
👉 http://localhost:8080/livros

🧑‍💻 Autor

Desenvolvido por Lucas Viana 🧠
💼 Projeto de estudo com foco em Spring Boot e APIs REST.

📫 Entre em Contato

Se você quiser trocar ideias, tirar dúvidas ou colaborar em projetos, sinta-se à vontade para entrar em contato!

💻 GitHub: github.com/Lcvianasz

💼 LinkedIn: linkedin.com/in/lucas-viana-souza

📧 E-mail: lucasvianasouza4@gmai.com

📌 Atualização do README – Novas Funcionalidades
🚀 Funcionalidades Implementadas

A API de Biblioteca evoluiu e agora conta com as seguintes funcionalidades:

✅ CRUD completo de livros

✅ Persistência em banco de dados relacional

✅ Uso de DTOs (Data Transfer Objects) para entrada e saída de dados

✅ Paginação na listagem de livros

✅ Tratamento de exceções padronizado

✅ Testes via Postman

✅ Versionamento com Git e GitHub

📦 DTOs (Data Transfer Objects)

Para melhorar a organização, segurança e desacoplamento da aplicação, foram implementados DTOs:

🔹 LivroRequestDTO

Utilizado para criação e atualização de livros.

Exemplo:

{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008,
  "isbn": "9780132350884"
}

🔹 LivroResponseDTO

Utilizado para retornar dados ao cliente, evitando exposição direta da entidade.

Exemplo:

{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008,
  "isbn": "9780132350884"
}

📄 Paginação

A listagem de livros agora suporta paginação, facilitando o consumo da API e melhorando a performance.

🔹 Endpoint
GET /api/livros

🔹 Parâmetros opcionais
Parâmetro	Descrição	Exemplo
page	Página (inicia em 0)	page=0
size	Quantidade por página	size=5
sort	Campo de ordenação	sort=titulo,asc
🔹 Exemplo de requisição
GET /api/livros?page=0&size=5&sort=titulo,asc

🔹 Exemplo de resposta
{
  "content": [
    {
      "id": 1,
      "titulo": "Clean Code",
      "autor": "Robert C. Martin",
      "anoPublicacao": 2008,
      "isbn": "9780132350884"
    }
  ],
  "totalElements": 10,
  "totalPages": 2,
  "size": 5,
  "number": 0
}

🧪 Testes com Postman

Todos os endpoints foram testados utilizando o Postman.

Exemplos de testes:

🔹 Criar livro (POST /api/livros)

🔹 Listar livros com paginação (GET /api/livros)

🔹 Buscar livro por ID (GET /api/livros/{id})

🔹 Atualizar livro (PUT /api/livros/{id})

🔹 Deletar livro (DELETE /api/livros/{id})

📈 Próximos Passos (Evolução do Projeto)

🔐 Implementar autenticação com Spring Security + JWT

🧪 Testes automatizados (JUnit e Mockito)

📑 Documentação com Swagger/OpenAPI

🧱 Camada de validação com Bean Validation

🐳 Dockerização da aplicação

📊 Logs e monitoramento
