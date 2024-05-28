package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    @Query("SELECT f FROM Filme f WHERE f.Title = :title")
    List<Filme> findByTitle(@Param("title") String title);

    @Query("SELECT f FROM Filme f WHERE f.Genre = :genre")
    List<Filme> findByGenre(@Param("genre") String genre);

    @Query("SELECT f FROM Filme f WHERE f.Year = :year")
    List<Filme> findByRelease(@Param("year") String year);

    @Query("SELECT f FROM Filme f WHERE (f.Title = :title) AND (f.Genre = :genre)")
    List<Filme> findByTitleAndGenre(@Param("title") String title, @Param("genre") String genre);

    @Query("SELECT f FROM Filme f WHERE (f.Title = :title) AND (f.Year = :year)")
    List<Filme> findByTitleAndRelease(@Param("title") String title, @Param("year") String year);

    @Query("SELECT f FROM Filme f WHERE (f.Genre = :genre) AND (f.Year = :year)")
    List<Filme> findByGenreAndRelease(@Param("genre") String genre, @Param("year") String year);

    @Query("SELECT f FROM Filme f WHERE ((f.Title = :title) AND (f.Genre = :genre) AND (f.Year = :year))")
    List<Filme> findByTitleGenreAndRelease(@Param("title") String title, @Param("genre") String genre, @Param("year") String year);

}
