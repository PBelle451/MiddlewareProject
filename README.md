# Middleware API

Projeto exemplo: middleware que consome ViaCEP e expõe dados tratados.

Tech stack: Java 21, Spring Boot 3.4, Feign, MapStruct, Lombok.

Instalação:
- Java 21 no PATH
- `mvn clean package`
- Rodar: `mvn spring-boot:run` ou executar o jar em `target/`

Endpoint:
GET /cep/{cep} -> retorna EnderecoDTO
