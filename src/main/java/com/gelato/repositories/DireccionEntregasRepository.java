package com.gelato.repositories;

import com.gelato.models.DireccionEntregas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionEntregasRepository extends JpaRepository<DireccionEntregas,Long> {
}
