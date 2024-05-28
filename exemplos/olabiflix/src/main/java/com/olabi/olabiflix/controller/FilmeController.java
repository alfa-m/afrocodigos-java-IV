package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeRepository repositorioFilmes;

    public FilmeController(FilmeRepository repositorioFilmes){
        this.repositorioFilmes = repositorioFilmes;
    }

    @GetMapping
    public List<Filme> getFilmes(@RequestParam(name = "title", required = false) String titulo,
                                 @RequestParam(name = "genre", required = false) String genero,
                                 @RequestParam(name = "year", required = false) String ano){
        if (titulo != null || genero != null || ano != null){
            if (titulo != null){
                if (genero == null && ano == null){
                    return repositorioFilmes.findByTitle(titulo);
                } else if (genero != null && ano == null) {
                    return repositorioFilmes.findByTitleAndGenre(titulo,genero);
                } else if (genero == null && ano != null) {
                    return repositorioFilmes.findByTitleAndRelease(titulo,ano);
                } else {
                    return repositorioFilmes.findByTitleGenreAndRelease(titulo,genero,ano);
                }
            } else if (genero != null) {
                if (ano == null){
                    return repositorioFilmes.findByGenre(genero);
                }
                else {
                    return repositorioFilmes.findByGenreAndRelease(genero,ano);
                }
            }
            else {
                return repositorioFilmes.findByRelease(ano);
            }
        }
        return repositorioFilmes.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmesById(@PathVariable("id") UUID id){
        return repositorioFilmes.findById(id);
    }

    @PostMapping("/criar")
    public Filme createFilme(@RequestBody Filme filmeBody){
        return repositorioFilmes.save(filmeBody);
    }

}
