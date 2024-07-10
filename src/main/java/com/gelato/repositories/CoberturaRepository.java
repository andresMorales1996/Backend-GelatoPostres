package com.gelato.repositories;

import com.gelato.models.Cobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoberturaRepository extends JpaRepository <Cobertura, Long> {
}
