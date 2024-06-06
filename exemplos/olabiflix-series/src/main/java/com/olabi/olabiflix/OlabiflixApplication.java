package com.olabi.olabiflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OlabiflixApplication {
	public static void main(String[] args) {
		SpringApplication.run(OlabiflixApplication.class, args);
	}

	@GetMapping("")
	public String home(){
		return "API de séries da OlabiFlix";
	}

	@GetMapping("/ola")
	public String hello(){
		return "Olar mundo!";
	}

}
