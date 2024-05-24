package com.olabi.olabiflix.repository;

import redeflix.model.entity.Filme;
import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID>{
}
