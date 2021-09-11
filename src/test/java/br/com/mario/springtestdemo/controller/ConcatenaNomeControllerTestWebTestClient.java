package br.com.mario.springtestdemo.controller;

import br.com.mario.springtestdemo.integration.RandomNameClient;
import br.com.mario.springtestdemo.service.ConcatenaNomeService;
import feign.Feign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class ConcatenaNomeControllerTestWebTestClient {

    @MockBean
    private RandomNameClient randomNameclient;

    WebTestClient outroClient;

    @BeforeEach
    void setUp(WebApplicationContext wac) {
        outroClient = MockMvcWebTestClient.bindToApplicationContext(wac).build();
    }

    @Autowired
    WebClient umClientai;
    @Test
    void deveRetornarNomeConcatenadoComPropriedade(){

        Mockito.when(randomNameclient.buscaNome()).thenReturn("Joselito");

        var response = outroClient.get()
                .uri("/o")
                .exchange()
                .expectBody(String.class)
                .returnResult();

        var algo =  response.getResponseBody();
        System.out.println(algo);

    }

}
