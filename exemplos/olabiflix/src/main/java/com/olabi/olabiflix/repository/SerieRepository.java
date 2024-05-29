package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SerieRepository extends JpaRepository<Serie, UUID> {
    @Query("SELECT s FROM Serie s WHERE s.title = :title")
    List<Serie> findByTitle(@Param("title") String title);

    @Query("SELECT s FROM Serie s WHERE s.genre = :genre")
    List<Serie> findByGenre(@Param("genre") String genre);

    @Query("SELECT s FROM Serie s WHERE (s.title = :title) AND (s.genre = :genre)")
    List<Serie> findByTitleAndGenre(@Param("title") String title, @Param("genre") String genre);

}
