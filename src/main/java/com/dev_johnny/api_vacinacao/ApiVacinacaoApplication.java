package com.dev_johnny.api_vacinacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.dev_johnny.api_vacinacao")
public class ApiVacinacaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiVacinacaoApplication.class, args);
	}

}
