package com.gelato.repositories;

import com.gelato.models.DireccionesEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionesEntregaRepository extends JpaRepository<DireccionesEntrega,Long> {
}
