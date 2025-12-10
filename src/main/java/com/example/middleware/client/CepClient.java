package com.example.middleware.client;

import com.example.middleware.dto.external.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "viacep",
        url = "${viacep.url}"    // vem do application.properties
)
public interface CepClient {

    @GetMapping("/{cep}/json")
    CepResponse buscarCep(@PathVariable("cep") String cep);
}
