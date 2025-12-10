package com.example.middleware.client;

import com.example.middleware.dto.external.CepResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CepClient {

    private final WebClient webClient;

    public CepClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public CepResponse buscarCep(String cep) {
        return webClient
                .get()
                .uri("https://viacep.com.br/ws/" + cep + "/json/")
                .retrieve()
                .bodyToMono(CepResponse.class)
                .block();
    }
}
