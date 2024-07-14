package com.gelato.repositories;

import com.gelato.models.MetodoPagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagosRepository extends JpaRepository<MetodoPagos, Long> {
}