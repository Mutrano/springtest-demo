package br.com.mario.springtestdemo.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "localhost:8081",name="random")
public interface RandomNameClient {

    @GetMapping("/nome")
    String buscaNome();
}
