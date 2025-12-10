package com.example.middleware.client;

import com.example.middleware.dto.external.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepClient", url = "${viacep.url}", configuration = com.example.middleware.config.FeignConfig.class)
public interface CepClient {

    @GetMapping("/{cep}/json/")
    CepResponse getCep(@PathVariable("cep") String cep);
}
