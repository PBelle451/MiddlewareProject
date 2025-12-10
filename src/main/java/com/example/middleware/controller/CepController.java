package com.example.middleware.controller;

import com.example.middleware.dto.internal.EnderecoDTO;
import com.example.middleware.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep){
        EnderecoDTO dto = service.buscarCep(cep);
        return ResponseEntity.ok(dto);
    }
}
