package com.olabi.olabiflix;

import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.repository.SerieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class OlabiflixApplication {
	private final SerieRepository repositorioSeries;

	public OlabiflixApplication(SerieRepository repositorioSeries){
		this.repositorioSeries = repositorioSeries;
	}

	public static void main(String[] args) {
		SpringApplication.run(OlabiflixApplication.class, args);
	}

	@GetMapping("/")
	public String home(){
		return "API do OlabiFlix";
	}

	@GetMapping("/hello")
	public String hello(){
		return "Salve, mundão!";
	}

	@GetMapping("/series")
	public List<Serie> getSeries() {
		return repositorioSeries.findAll();
	}

	@PostMapping("/series/criar")
	public Serie createSerie(@RequestBody Serie serieBody){
		return repositorioSeries.save(serieBody);
	}

}
