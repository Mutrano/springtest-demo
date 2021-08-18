package br.com.mario.springtestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringtestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtestDemoApplication.class, args);
	}

}
