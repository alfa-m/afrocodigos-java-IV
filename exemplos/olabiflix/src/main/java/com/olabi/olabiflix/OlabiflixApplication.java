package com.olabi.olabiflix;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.model.value.Ratings;
import com.olabi.olabiflix.repository.FilmeRepository;
import com.olabi.olabiflix.repository.SerieRepository;
import com.olabi.olabiflix.repository.RatingsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class OlabiflixApplication {
	private final FilmeRepository repositorioFilmes;
	private final SerieRepository repositorioSeries;
	private final RatingsRepository repositorioRatings;

	public OlabiflixApplication(FilmeRepository repositorioFilmes, SerieRepository repositorioSeries, RatingsRepository repositorioRatings){
		this.repositorioFilmes = repositorioFilmes;
		this.repositorioSeries = repositorioSeries;
		this.repositorioRatings = repositorioRatings;
	}

	public static void main(String[] args) {
		SpringApplication.run(OlabiflixApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "Salve, mundão!";
	}

	@GetMapping("/filmes")
	public List<Filme> getFilmes(){
		return repositorioFilmes.findAll();
	}

	@GetMapping("/series")
	public List<Serie> getSeries() {
		return repositorioSeries.findAll();
	}

	@GetMapping("/ratings")
	public List<Ratings> getRatings(){
		return repositorioRatings.findAll();
	}
}
