# 📦 Middleware API — CEP Lookup

API middleware em Java que consome a API pública [ViaCEP](https://viacep.com.br/) e expõe os dados tratados via endpoint REST.

---

## 🛠️ Tech Stack

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.0 |
| Spring Cloud OpenFeign | 2025.1.0 |
| MapStruct | 1.6.3 |
| Lombok | latest |
| SpringDoc OpenAPI (Swagger) | 2.6.0 |

---

## 📋 Pré-requisitos

- **Java 21** instalado e configurado no `PATH`
- **Maven 3.9+** (ou use o wrapper incluído `./mvnw`)

---

## 🚀 Como rodar

### 1. Clone o repositório

```bash
git clone https://github.com/PBelle451/MiddlewareProject.git
cd MiddlewareProject
```

### 2. Build do projeto

```bash
./mvnw clean package
```

### 3. Execute a aplicação

**Via Maven:**
```bash
./mvnw spring-boot:run
```

**Via JAR:**
```bash
java -jar target/middleware-0.0.1-SNAPSHOT.jar
```

A aplicação sobe por padrão em `http://localhost:8080`.

---

## 🔌 Endpoints

### `GET /cep/{cep}`

Consulta os dados de um CEP via ViaCEP e retorna um `EnderecoDTO` tratado.

**Exemplo de requisição:**
```
GET http://localhost:8080/cep/01310100
```

**Exemplo de resposta:**
```json
{
  "cep": "01310-100",
  "logradouro": "Avenida Paulista",
  "bairro": "Bela Vista",
  "cidade": "São Paulo",
  "uf": "SP"
}
```

---

## 📖 Documentação interativa (Swagger)

Com a aplicação rodando, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 🏗️ Arquitetura

```
Client
  │
  ▼
[ Controller ]   ← recebe a requisição REST
  │
  ▼
[ Service ]      ← orquestra a lógica de negócio
  │
  ▼
[ Feign Client ] ← consome a API externa (ViaCEP)
  │
  ▼
[ MapStruct ]    ← mapeia ViaCEP response → EnderecoDTO
  │
  ▼
[ EnderecoDTO ]  ← retornado ao cliente
```

---

## 🧪 Testes

```bash
./mvnw test
```

Os testes utilizam **MockMvc** e **Mockito** via `spring-boot-starter-test`.

---

## 📄 Licença

Distribuído sob a licença [MIT](LICENSE).
