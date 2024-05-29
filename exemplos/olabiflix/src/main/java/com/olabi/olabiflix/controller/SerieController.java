package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.repository.SerieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final SerieRepository repositorioSeries;

    public SerieController(SerieRepository repositorioSeries) {
        this.repositorioSeries = repositorioSeries;
    }

    @GetMapping
    public List<Serie> getSeries(@RequestParam(name = "title", required = false) String titulo,
                                 @RequestParam(name = "genre", required = false) String genero){
        if (titulo == null && genero == null){
            return repositorioSeries.findAll();
        } else if (genero == null) {
            return repositorioSeries.findByTitle(titulo);
        } else if (titulo == null) {
            return repositorioSeries.findByGenre(genero);
        } else{
            return repositorioSeries.findByTitleAndGenre(titulo,genero);
        }
    }

    @GetMapping("/{id}")
    public Optional<Serie> getSeriesById(@PathVariable("id") UUID id){
        return repositorioSeries.findById(id);
    }

    @PostMapping("/criar")
    public Serie createSerie(@RequestBody Serie serieBody){
        return repositorioSeries.save(serieBody);
    }
}
