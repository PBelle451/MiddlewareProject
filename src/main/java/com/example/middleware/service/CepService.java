package com.example.middleware.service;

import com.example.middleware.client.CepClient;
import com.example.middleware.domain.Address;
import com.example.middleware.dto.internal.EnderecoDTO;
import com.example.middleware.mapper.CepMapper;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    private final CepClient client;
    private final CepMapper mapper;

    public CepService(CepClient client, CepMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    public EnderecoDTO buscarCep(String cep) {
        var external = client.buscarCep(cep);
        var address = mapper.toAddress(external);
        return mapper.toDTO(address);
    }
}
