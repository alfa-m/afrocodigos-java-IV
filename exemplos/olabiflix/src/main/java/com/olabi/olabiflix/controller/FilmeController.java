package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/criar")
    public Filme createFilme(@RequestBody Filme filmeBody){
        return repositorioFilmes.save(filmeBody);
    }

}
