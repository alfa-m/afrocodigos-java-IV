package com.olabi.olabiflix.config;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.model.value.Ratings;
import com.olabi.olabiflix.repository.FilmeRepository;
import com.olabi.olabiflix.repository.SerieRepository;
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

    public DatabaseInitializer(FilmeRepository filmeRepository, SerieRepository serieRepository){
        this.filmeRepository = filmeRepository;
        this.serieRepository = serieRepository;
    }

    public static final List<Filme> filmes = List.of(
            new Filme("10 Things I Hate About You","1999","PG-13","31 Mar 1999","97 min","Comedy, Drama, Romance","Gil Junger","Karen McCullah, Kirsten Smith, William Shakespeare","Heath Ledger, Julia Stiles, Joseph Gordon-Levitt","A high-school boy, Cameron, cannot date Bianca until her anti-social older sister, Kat, has a boyfriend. So, Cameron pays a mysterious boy, Patrick, to charm Kat.","English, French","United States","2 wins & 13 nominations"),
            new Filme("Inception","2010","PG-13","16 Jul 2010","148 min","Action, Adventure, Sci-Fi, Thriller","Christopher Nolan","Christopher Nolan","Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.","English, Japanese, French","United States, United Kingdom","Won 4 Oscars. 159 wins & 220 nominations total"),
            new Filme("Avatar","2009","PG-13","18 Dec 2009","162 min","Action, Adventure, Fantasy, Sci-Fi","James Cameron","James Cameron","Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang","A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.","English, Spanish","USA","Won 3 Oscars. Another 86 wins & 129 nominations."),
            new Filme("Doctor Strange","2016","PG-13","04 Nov 2016","115 min","Action, Adventure, Fantasy, Sci-Fi","Scott Derrickson","Jon Spaihts, Scott Derrickson, C. Robert Cargill, Stan Lee (based on the Marvel comics by), Steve Ditko (based on the Marvel comics by)","Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams, Benedict Wong","While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.","English","USA","Nominated for 1 Oscar. Another 20 wins & 65 nominations."),
            new Filme("The Truman Show","1998","PG","05 Jun 1998","103 min","Comedy, Drama, Sci-Fi","Peter Weir","Andrew Niccol","Jim Carrey, Laura Linney, Noah Emmerich, Natascha McElhone","An insurance salesman discovers his whole life is actually a reality TV show.","English","USA","Nominated for 3 Oscars. Another 40 wins & 66 nominations.")
    );

    public static final List<Serie> series = List.of(
            new Serie("Game of Thrones","8",new ArrayList<String>(Arrays.asList("Action","Adventure","Drama","Fantasy","Romance")),new ArrayList<String>(Arrays.asList("David Benioff","D.B. Weiss")),"https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Peter Dinklage","Lena Headey","Emilia Clarke","Kit Harington")),new Ratings("9.3","1679892")),
            new Serie("Stranger Things","3",new ArrayList<String>(Arrays.asList("Drama","Fantasy","Horror","Mystery","Sci-Fi","Thriller")),new ArrayList<String>(Arrays.asList("Matt Duffer","Ross Duffer")),"https://m.media-amazon.com/images/M/MV5BMjEzMDAxOTUyMV5BMl5BanBnXkFtZTgwNzAxMzYzOTE@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Winona Ryder","David Harbour","Finn Wolfhard","Millie Bobby Brown")),new Ratings("8.8","769106")),
            new Serie("The Boys","3",new ArrayList<String>(Arrays.asList("Action","Comedy","Crime","Sci-Fi")),new ArrayList<String>(Arrays.asList("Eric Kripke")),"https://m.media-amazon.com/images/M/MV5BN2JjNmFjZmItMDVlMS00NzExLWJkOTMtY2U3ZDRiZGUyMTdhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Karl Urban","Jack Quaid","Antony Starr","Erin Moriarty")),new Ratings("8.7","162770")),
            new Serie("This Is Us","4",new ArrayList<String>(Arrays.asList("Comedy","Drama","Romance")),new ArrayList<String>(Arrays.asList("Dan Fogelman")),"https://m.media-amazon.com/images/M/MV5BMDM2YTMzMWMtNmFhZi00ZWY4LTk1ZmUtMWExNzg3NDZmMTY4XkEyXkFqcGdeQXVyMzQ2MDI5NjU@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Milo Ventimiglia", "Mandy Moore","Sterling K. Brown","Chrissy Metz")),new Ratings("8.7","94108")),
            new Serie("How to Get Away with Murder","6",new ArrayList<String>(Arrays.asList("Crime","Drama","Mystery","Thriller")),new ArrayList<String>(Arrays.asList("Peter Nowalk")), "https://m.media-amazon.com/images/M/MV5BZDQ5ZDRhMWItNjA5Ni00MDhiLTgwN2EtZjFkYzgzNjBhZTIyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg", new ArrayList<String>(Arrays.asList("Viola Davis","Billy Brown","Jack Falahee","Aja Naomi King")),new Ratings("8.1","120538")),
            new Serie("Little Fires Everywhere","1",new ArrayList<String>(Arrays.asList("Drama")),new ArrayList<String>(Arrays.asList("Celeste Ng")), "https://m.media-amazon.com/images/M/MV5BNmEyZjc3MzgtZjU1OS00MDlkLThmOTMtODE5OTlmYmUxMTRmXkEyXkFqcGdeQXVyMTM1NjgyNDI@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Kerry Washington","Lexi Underwood","Reese Witherspoon","Joshua Jackson")),new Ratings("7.8","19360")),
            new Serie("Lucifer","5",new ArrayList<String>(Arrays.asList("Crime","Drama","Fantasy")),new ArrayList<String>(Arrays.asList("Tom Kapinos")), "https://m.media-amazon.com/images/M/MV5BNzY1YjIxOGMtOTAyZC00YTcyLWFhMzQtZTJkYTljYzU0MGRlXkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Tom Ellis","Lauren German","Kevin Alejandro","D.B. Woodside")),new Ratings("8.2","211722")),
            new Serie("Anne with an E","3",new ArrayList<String>(Arrays.asList("Drama")),new ArrayList<String>(Arrays.asList("Moira Walley-Beckett")), "https://m.media-amazon.com/images/M/MV5BNThmMzJlNzgtYmY5ZC00MDllLThmZTMtNTRiMjQwNmY0NmRhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Amybeth McNulty","Geraldine James","R.H. Thomson","Dalila Bela")),new Ratings("8.7","30924")),
            new Serie("Breaking Bad","5",new ArrayList<String>(Arrays.asList("Crime","Drama","Thriller")),new ArrayList<String>(Arrays.asList("Vince Gilligan")), "https://m.media-amazon.com/images/M/MV5BMTg4NjEyNjA1NF5BMl5BanBnXkFtZTgwOTU2Mjg3NDE@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Bryan Cranston","Aaron Paul","Anna Gunn","Betsy Brandt")),new Ratings("9.5","1496588")),
            new Serie("Friends","10",new ArrayList<String>(Arrays.asList("Comedy","Romance")),new ArrayList<String>(Arrays.asList("David Crane","Marta Kauffman")), "https://m.media-amazon.com/images/M/MV5BMjE0NjY3MjY4Ml5BMl5BanBnXkFtZTgwNjUyNzY3NTM@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Jennifer Aniston","Courteney Cox","Lisa Kudrow","Matt LeBlanc")), new Ratings("8.9","873458")),
            new Serie("Sherlock","4",new ArrayList<String>(Arrays.asList("Crime","Drama","Mystery","Thriller")),new ArrayList<String>(Arrays.asList("Mark Gatiss","Steven Moffat")), "https://m.media-amazon.com/images/M/MV5BMTUyMTA5ODQwMl5BMl5BanBnXkFtZTcwOTc4NDQ5Mw@@._V1_SX300.jpg",new ArrayList<String>(Arrays.asList("Benedict Cumberbatch","Martin Freeman","Una Stubbs","Rupert Graves")),new Ratings("9.1","884329"))

            );

    @Override
    public void run(String... args) throws Exception {
        log.info("Banco conectado");
        log.info("Inserindo filmes...");
        filmeRepository.saveAll(filmes);
        log.info("Filmes inseridos com sucesso!");
        //log.info("Mostrando lista de filmes");
        //filmeRepository.findAll().forEach(filme -> System.out.printf("\nFilme\nTítulo: %s\nID: %s \n", filme.getTitle(), filme.getId().toString()));

        log.info("Inserindo séries...");
        serieRepository.saveAll(series);
        log.info("Séries inseridas com sucesso!");
        //log.info("Mostrando lista de séries");
        //serieRepository.findAll().forEach(serie -> System.out.printf("\nSérie\nTítulo: %s\nID: %s \nRating: %s\nLikes: %s", serie.getTitle(), serie.getId().toString(), serie.getRatings().getRating(), serie.getRatings().getLikes()));
    }
}
