package br.com.mario.springtestdemo.controller;

import br.com.mario.springtestdemo.service.ConcatenaNomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ConcatenaNomeController {

    @Autowired
    private ConcatenaNomeService service;


    @GetMapping("{nome}")
    public String concatena(@PathVariable String nome){

        var concatenado = service.concatenar(nome);
        return concatenado;

    }
}
