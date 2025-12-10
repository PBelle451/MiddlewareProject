package com.example.middleware.controller;

import com.example.middleware.dto.internal.EnderecoDTO;
import com.example.middleware.service.CepService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    @GetMapping("/{cep}")
    public EnderecoDTO buscar(@PathVariable String cep) {
        return service.buscarCep(cep);
    }
}
