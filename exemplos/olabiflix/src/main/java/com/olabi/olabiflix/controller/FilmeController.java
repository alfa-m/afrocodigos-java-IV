package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeRepository filmeRepository;
    public static final Logger log = LoggerFactory.getLogger(FilmeController.class);

    public FilmeController(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public List<Filme> getFilmes(){
        return filmeRepository.findAll();
    }
}
