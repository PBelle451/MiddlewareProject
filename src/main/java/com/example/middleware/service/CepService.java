package com.example.middleware.service;

import com.example.middleware.client.CepClient;
import com.example.middleware.domain.Address;
import com.example.middleware.dto.internal.EnderecoDTO;
import com.example.middleware.dto.external.CepResponse;
import com.example.middleware.exception.ApiException;
import com.example.middleware.mapper.CepMapper;
import com.example.middleware.util.StringUtils;
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
        if (StringUtils.isEmpty(cep)) {
            throw new ApiException("CEP não pode ser vazio", 400);
        }

        // sanitizar
        String cleanCep = cep.replaceAll("\\D", "");
        if (cleanCep.length() != 8) {
            throw new ApiException("CEP inválido: deve ter 8 dígitos", 400);
        }

        CepResponse response = CepClient.getCep(cleanCep);
        if (response == null || response.getCep() == null) {
            throw new ApiException("CEP não encontrado", 404);
        }

        Address address = mapper.toAddress(response);
        return mapper.toDTO(address);
    }
}
