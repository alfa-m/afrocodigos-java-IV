package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    List<Filme> findFilmeByTitleContainsIgnoreCase(String Title);
    List<Filme> findFilmeByReleaseYearIs(String ReleaseYear);
    List<Filme> findFilmeByGenreContainsIgnoreCase(String Genre);

    List<Filme> findFilmeByTitleContainsIgnoreCaseOrReleaseYearIs(String Title, String ReleaseYear);
    List<Filme> findFilmeByTitleContainsIgnoreCaseOrGenreContainsIgnoreCase(String Title, String Genre);
    List<Filme> findFilmeByReleaseYearIsOrGenreContainsIgnoreCase(String ReleaseYear, String Genre);

    List<Filme> findFilmeByTitleContainsIgnoreCaseOrReleaseYearIsOrGenreContainsIgnoreCase(String Title, String ReleaseYear, String Genre);
}
