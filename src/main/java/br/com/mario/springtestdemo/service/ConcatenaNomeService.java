package br.com.mario.springtestdemo.service;

import br.com.mario.springtestdemo.integration.RandomNameClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConcatenaNomeService {

    @Value("${propriedade}")
    private String propriedade;

    @Autowired
    private RandomNameClient client;

    public String concatenar(String nome) {
        var nomeBuscado = client.buscaNome();
        return nome +" "+ nomeBuscado + " "+ propriedade;

    }
}

