package br.com.mario.springtestdemo.controller;

import br.com.mario.springtestdemo.integration.RandomNameClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //subir o servidor numa porta aleatoria
public class ConcatenaNomeControllerTestRunningServerTestRestTemplate {

    @MockBean
    private RandomNameClient randomNameclient;

    //o spring ja configura o bind no servidor
    @Autowired
    TestRestTemplate umClient;

    @Test
    void deveRetornarNomeConcatenadoComPropriedade(){
        Mockito.when(randomNameclient.buscaNome()).thenReturn("Joselito");

        var response = umClient.getForEntity("/o",String.class);

        var algo =  response.getBody();
        System.out.println(algo);
    }

}
