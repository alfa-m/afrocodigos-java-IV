package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.value.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RatingsRepository extends JpaRepository<Ratings, Long> {
}
