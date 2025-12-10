package com.example.middleware.dto.external;

import lombok.Data;

@Data
public class CepResponse {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
