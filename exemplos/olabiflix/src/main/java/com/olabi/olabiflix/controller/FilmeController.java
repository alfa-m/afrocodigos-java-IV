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
    public List<Filme> getFilmes(){
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
