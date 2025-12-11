package com.example.middleware.mapper;

import com.example.middleware.domain.Address;
import com.example.middleware.dto.external.CepResponse;
import com.example.middleware.dto.internal.EnderecoDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CepMapperTest {
    private final CepMapper mapper = Mappers.getMapper(CepMapper.class);

    @Test
    void deveConverterCepResponseParaAddress() {
        CepResponse res = new CepResponse();
        res.setLogradouro("Praça da Sé");
        res.setBairro("Sé");
        res.setLocalidade("São Paulo");
        res.setCep("01001-000");

        Address address = mapper.toAddress(res);

        assertEquals("Praça da Sé", address.getRua());
        assertEquals("Sé", address.getBairro());
    }

    @Test
    void deveConverterAddressParaDTO() {
        Address a = new Address();
        a.setRua("Praça da Sé");
        a.setBairro("Sé");
        a.setCidade("São Paulo");
        a.setEstado("SP");
        a.setCep("01001000");

        EnderecoDTO dto = mapper.toDTO(a);

        assertEquals("01001000", dto.getCep());
    }
}
