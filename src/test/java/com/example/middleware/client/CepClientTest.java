package com.example.middleware.client;

import com.example.middleware.dto.external.CepResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableFeignClients(clients = CepClient.class)
@ActiveProfiles("test")
public class CepClientTest {

    @Autowired
    private CepClient client;

    @Test
    void contextoCarregaFeignClient() {
        assertNotNull(client);
    }
}
