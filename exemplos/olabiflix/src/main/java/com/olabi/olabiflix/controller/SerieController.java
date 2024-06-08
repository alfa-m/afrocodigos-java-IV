package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.repository.SerieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.olabi.olabiflix.model.value.Ratings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final SerieRepository serieRepository;
    public static final Logger log = LoggerFactory.getLogger(SerieController.class);

    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @PostMapping("/create")
    public Serie createSeries(@RequestBody Serie serieBody){
        log.info("Criando a série '" + serieBody.getTitle() + "' no banco de dados");
        return serieRepository.save(serieBody);
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getSeries (@RequestParam (name = "title", required = false) String titulo,
                                                  @RequestParam (name = "genre", required = false) String genero){
        if (titulo != null && genero == null){
            log.info("Buscando séries que contenham '" + titulo + "' no título");
            List<Serie> serie = serieRepository.findSerieByTitleContainsIgnoreCase(titulo);
            return ResponseEntity.ok(serie);
        } else if (titulo == null && genero != null) {
            log.info("Buscando séries que contenham o gênero '" + genero);
            List<Serie> serie = serieRepository.findSerieByGenreEqualsIgnoreCase(genero);
            return ResponseEntity.ok(serie);
        } else if (titulo != null && genero != null) {
            log.info("Buscando séries que contenham '" + titulo + "' no título ou o gênero '" + genero);
            List<Serie> serie = serieRepository.findSerieByTitleContainsIgnoreCaseOrGenreEqualsIgnoreCase(titulo, genero);
            return ResponseEntity.ok(serie);
        }

        log.info("Buscando todas as séries salvas no banco de dados");
        return ResponseEntity.of(Optional.of(serieRepository.findAll()));
    }

    @GetMapping("/{id}")
    public Optional<Serie> getSeriesById(@PathVariable UUID id){
        log.info("Buscando série com a id " + id);
        return serieRepository.findById(id);
    }

    @PutMapping("/{id}/modify")
    public ResponseEntity<Serie> totallyModifySeries(@PathVariable UUID id, @RequestBody Serie serieBody){
        Optional<Serie> serieProcurada = serieRepository.findById(id);

        if(serieProcurada.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Serie serieEncontrada = serieProcurada.get();

        serieEncontrada.setTitle(serieBody.getTitle());
        serieEncontrada.setActors(serieBody.getActors());
        serieEncontrada.setGenre(serieBody.getGenre());
        serieEncontrada.setPoster(serieBody.getPoster());
        serieEncontrada.setTotalSeasons(serieBody.getTotalSeasons());
        serieEncontrada.setWriters(serieBody.getWriters());
        serieEncontrada.setRatings(serieBody.getRatings());

        log.info("Modificando as informações da série '" + serieEncontrada.getTitle() + "'");
        Serie serieModificada = serieRepository.save(serieEncontrada);
        return ResponseEntity.ok(serieModificada);
    }

    @PatchMapping("/{id}/like")
    public ResponseEntity<Serie> likeSeries(@PathVariable UUID id){
        Optional<Serie> serieProcurada = serieRepository.findById(id);

        if(serieProcurada.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Serie serieEncontrada = serieProcurada.get();
        Ratings avaliacao = serieEncontrada.getRatings();

        Integer likesAtuais = Integer.parseInt(avaliacao.getLikes());
        Integer like = likesAtuais + 1;
        avaliacao.setLikes(String.valueOf(like));

        log.info("Dando like na série '" + serieEncontrada.getTitle() + "'");
        serieRepository.save(serieEncontrada);
        return ResponseEntity.ok(serieEncontrada);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Serie> deleteSeriesById(@PathVariable UUID id){
        Optional<Serie> serieProcurada = serieRepository.findById(id);

        if(serieProcurada.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Serie serieEncontrada = serieProcurada.get();
        log.info("Removendo a série '" + serieEncontrada.getTitle() + "' do banco de dados");
        serieRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
