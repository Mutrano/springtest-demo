package br.com.mario.springtestdemo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest    // sobe o contexto do spring
@TestPropertySource("/application-test.properties") // aponta o properties de teste
public class ConcatenaNomeControllerTest {


    private MockMvc mockMvc;

    @BeforeEach
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();   // faz o setup do mockMvc com o contexto inteiro
    }

    //esta sem mocks na integracao externa
    @Test
    void deveRetornarNomeConcatenadoComPropriedade() throws Exception {


        mockMvc.perform(get("/o"))
                .andDo(print());



    }
}