package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.exception.FilmeException;
import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    public static final Logger log = LoggerFactory.getLogger(FilmeController.class);
    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public List<Filme> getFilmes(@RequestParam (name = "title", required = false) String title,
                                 @RequestParam (name = "year", required = false) String year,
                                 @RequestParam (name = "genre", required = false) String genre) {
        if (title != null) {
            if (year == null && genre == null) {
                log.info("Buscando filmes que contenham '" + title + "' no título");
                return filmeRepository.findFilmeByTitleContainsIgnoreCase(title);
            }
            else if (year != null && genre == null) {
                log.info("Buscando filmes que contenham '" + title + "' no título ou foram lançados em " + year);
                return filmeRepository.findFilmeByTitleContainsIgnoreCaseOrReleaseYearIs(title, year);
            }
            else if (year == null && genre != null) {
                log.info("Buscando filmes que contenham '" + title + "' no título ou tenham o gênero '" + genre + "'");
                return filmeRepository.findFilmeByTitleContainsIgnoreCaseOrGenreContainsIgnoreCase(title, genre);
            }
            else {
                log.info("Buscando filmes que contenham '" + title + "' no título, foram lançados em " + year + " ou tenham o gênero '" + genre + "'");
                return filmeRepository.findFilmeByTitleContainsIgnoreCaseOrReleaseYearIsOrGenreContainsIgnoreCase(title, year, genre);
            }
        } else if (year != null) {
            if (genre == null) {
                log.info("Buscando filmes lançados em " + year);
                return filmeRepository.findFilmeByReleaseYearIs(year);
            } else {
                log.info("Buscando filmes lançados em " + year + " ou que contenham o gênero '" + genre + "'");
                return filmeRepository.findFilmeByReleaseYearIsOrGenreContainsIgnoreCase(year, genre);
            }
        } else if (genre != null) {
            log.info("Buscando filmes que contenham o gênero '" + genre + "'");
            return filmeRepository.findFilmeByGenreContainsIgnoreCase(genre);
        }

        log.info("Buscando todos os filmes no banco de dados");
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmeById(@PathVariable UUID id){
        log.info("Buscando filme com o id " + id);
        return filmeRepository.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createFilme(@RequestBody Filme filme){
        boolean filmeExiste = filmeRepository.existsFilmeByTitleAndReleaseYearAndDirectorAndWriter(filme.getTitle(), filme.getReleaseYear(), filme.getDirector(), filme.getWriter());

        if (filmeExiste){
            String mensagemErro = new FilmeException.FilmeDuplicadoException().getMessage();
            return new ResponseEntity<>(mensagemErro, HttpStatus.CONFLICT);
        }

        log.info("Adicionando o filme '" + filme.getTitle() + "' no banco de dados");
        return ResponseEntity.ok(filmeRepository.save(filme));
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Filme> modifyWholeFilme(@PathVariable UUID id, @RequestBody Filme filme){
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);

        if (filmeProcurado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Filme filmeEncontrado = filmeProcurado.get();

        filmeEncontrado.setTitle(filme.getTitle());
        filmeEncontrado.setReleaseYear(filme.getReleaseYear());
        filmeEncontrado.setRated(filme.getRated());
        filmeEncontrado.setReleased(filme.getReleased());
        filmeEncontrado.setRuntime(filme.getRuntime());
        filmeEncontrado.setGenre(filme.getGenre());
        filmeEncontrado.setDirector(filme.getDirector());
        filmeEncontrado.setWriter(filme.getWriter());
        filmeEncontrado.setActors(filme.getActors());
        filmeEncontrado.setPlot(filme.getPlot());
        filmeEncontrado.setLanguage(filme.getLanguage());
        filmeEncontrado.setCountry(filme.getCountry());
        filmeEncontrado.setAwards(filme.getAwards());

        log.info("Atualizando todas as informações do filme '" + filmeEncontrado.getTitle() + "'");
        return ResponseEntity.ok(filmeRepository.save(filmeEncontrado));
    }

    @PatchMapping ("/modify/{id}")
    public ResponseEntity<Filme> modifyFilme(@PathVariable UUID id, @RequestBody Map<String, String> filmeBody) throws IllegalAccessException{
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);

        if (filmeProcurado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Filme filmeEncontrado = filmeProcurado.get();
        List<Field> camposDaModel = List.of(filmeEncontrado.getClass().getDeclaredFields());

        for(Field campo : camposDaModel){
            campo.setAccessible(true);
            String nomeCampo = campo.getName();
            if(filmeBody.containsKey(nomeCampo)){
                String valorAtualizado = filmeBody.get(nomeCampo);
                campo.set(filmeEncontrado, valorAtualizado);
            }
        }

        log.info("Atualizando as informações do filme '" + filmeEncontrado.getTitle() + "'");
        return ResponseEntity.ok(filmeRepository.save(filmeEncontrado));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);

        if (filmeProcurado.isEmpty()) {
            log.info("ID não encontrada no banco de dados");
        }

        Filme filmeParaRemover = filmeProcurado.get();
        log.info("Removendo o filme '" + filmeParaRemover.getTitle() + "' o banco de dados");
        filmeRepository.deleteById(id);
    }
}
