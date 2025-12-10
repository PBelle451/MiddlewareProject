package com.example.middleware.controller;

import com.example.middleware.dto.internal.EnderecoDTO;
import com.example.middleware.service.CepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CepControllerTest {

    private MockMvc mvc;

    @Mock
    private CepService service;

    @InjectMocks
    private CepController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void deveRetornarEndereco() throws Exception {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setCep("01001000");

        when(service.buscarCep("01001000")).thenReturn(dto);

        mvc.perform(get("/cep/01001000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep").value("01001000"));
    }
}
