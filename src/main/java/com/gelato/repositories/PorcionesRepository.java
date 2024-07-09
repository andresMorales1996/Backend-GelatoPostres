package com.gelato.repositories;

import com.gelato.models.Porciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorcionesRepository extends JpaRepository<Porciones, Long> {
}
