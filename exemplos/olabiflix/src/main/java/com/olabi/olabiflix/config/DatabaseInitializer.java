package com.olabi.olabiflix.config;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.model.value.Ratings;
import com.olabi.olabiflix.repository.FilmeRepository;
import com.olabi.olabiflix.repository.SerieRepository;
import com.olabi.olabiflix.repository.RatingsRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class DatabaseInitializer implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    private final FilmeRepository filmeRepository;
    private final SerieRepository serieRepository;
    private final RatingsRepository ratingsRepository;

    public DatabaseInitializer(FilmeRepository filmeRepository, SerieRepository serieRepository, RatingsRepository ratingsRepository){
        this.filmeRepository = filmeRepository;
        this.serieRepository = serieRepository;
        this.ratingsRepository = ratingsRepository;
    }

    public static final List<Filme> filmes = List.of(
            new Filme("10 Things I Hate About You","1999","PG-13","31 Mar 1999","97 min","Comedy, Drama, Romance","Gil Junger","Karen McCullah, Kirsten Smith, William Shakespeare","Heath Ledger, Julia Stiles, Joseph Gordon-Levitt","A high-school boy, Cameron, cannot date Bianca until her anti-social older sister, Kat, has a boyfriend. So, Cameron pays a mysterious boy, Patrick, to charm Kat.","English, French","United States","2 wins & 13 nominations"),
            new Filme("Inception","2010","PG-13","16 Jul 2010","148 min","Action, Adventure, Sci-Fi, Thriller","Christopher Nolan","Christopher Nolan","Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.","English, Japanese, French","United States, United Kingdom","Won 4 Oscars. 159 wins & 220 nominations total")
    );

    public static final List<Serie> series = List.of(
            new Serie("Game of Thrones","8",new ArrayList<String>(Arrays.asList("Action","Adventure","Drama","Fantasy","Romance")),new ArrayList<String>(Arrays.asList("David Benioff","D.B. Weiss")),"https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Peter Dinklage","Lena Headey","Emilia Clarke","Kit Harington")),new Ratings("9.3","1679892"))
            //new Serie("Game of Thrones","8",new ArrayList<String>(Arrays.asList("Action","Adventure","Drama","Fantasy","Romance")),new ArrayList<String>(Arrays.asList("David Benioff","D.B. Weiss")),"https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Peter Dinklage","Lena Headey","Emilia Clarke","Kit Harington")))
    );

    @Override
    public void run(String... args) throws Exception {
        log.info("Banco conectado");
        filmeRepository.saveAll(filmes);
        filmeRepository.findAll().forEach(filme -> System.out.printf("\nFilme\nTítulo: %s\nID: %s \n", filme.getTitle(), filme.getId().toString()));

        serieRepository.saveAll(series);
        serieRepository.findAll().forEach(serie -> System.out.printf("\nSérie\nTítulo: %s\nID: %s \n", serie.getTitle(), serie.getId().toString()));
    }
}
