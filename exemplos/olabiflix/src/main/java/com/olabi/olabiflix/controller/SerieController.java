package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.repository.SerieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final SerieRepository repositorioSeries;

    public SerieController(SerieRepository repositorioSeries) {
        this.repositorioSeries = repositorioSeries;
    }

    @GetMapping
    public List<Serie> getSeries() {
        return repositorioSeries.findAll();
    }

    @PostMapping("/criar")
    public Serie createSerie(@RequestBody Serie serieBody){
        return repositorioSeries.save(serieBody);
    }
}
