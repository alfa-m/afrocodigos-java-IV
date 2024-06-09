package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, UUID> {
    List<Serie> findSerieByTitleContainsIgnoreCase(String title);
    List<Serie> findSerieByGenreEqualsIgnoreCase(String genre);
    List<Serie> findSerieByTitleContainsIgnoreCaseOrGenreEqualsIgnoreCase(String title, String genre);
}
