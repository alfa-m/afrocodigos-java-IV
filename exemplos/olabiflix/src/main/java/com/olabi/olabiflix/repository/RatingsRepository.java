package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.value.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingsRepository extends JpaRepository<Ratings, UUID> {
}
