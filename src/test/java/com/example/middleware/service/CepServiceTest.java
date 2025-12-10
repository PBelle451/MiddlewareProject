package com.example.middleware.service;

import com.example.middleware.client.CepClient;
import com.example.middleware.domain.Address;
import com.example.middleware.dto.external.CepResponse;
import com.example.middleware.dto.internal.EnderecoDTO;
import com.example.middleware.exception.ApiException;
import com.example.middleware.mapper.CepMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CepServiceTest {

    @Mock
    private CepClient client;

    @Mock
    private CepMapper mapper;

    @InjectMocks
    private CepService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarEnderecoQuandoCepValido(){
        String cep = "01001000";

        CepResponse external = new CepResponse();
        external.setCep("01001-000");
        external.setLogradouro("Praça da Sé");
        external.setBairro("Sé");
        external.setLocalidade("São Paulo");
        external.setUf("SP");

        Address domain = new Address();
        domain.setStreet("Praça da Sé");

        EnderecoDTO dto = new EnderecoDTO();
        dto.setCep("01001000");

        when(client.buscarCep("01001000")).thenReturn(external);
        when(mapper.toAddress(external)).thenReturn(domain);
        when(mapper.toDTO(domain)).thenReturn(dto);

        EnderecoDTO result = service.buscarCep(cep);

        assertNotNull(result);
        assertEquals("01001000", result.getCep());
    }

    @Test
    void deveLancarErroQuandoCepInvalido() {
        ApiException e = assertThrows(ApiException.class, () -> service.buscarCep("123"));
        assertEquals(400, e.getStatus());
    }

    @Test
    void deveLancarErroQuandoCepNaoEncontrado() {
        when(client.buscarCep("01001000")).thenReturn(null);

        ApiException e = assertThrows(ApiException.class, () -> service.buscarCep("01001000"));
        assertEquals(404, e.getStatus());
    }

}
