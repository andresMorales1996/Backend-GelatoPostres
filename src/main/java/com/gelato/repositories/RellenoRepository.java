package com.gelato.repositories;

import com.gelato.models.Relleno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RellenoRepository extends JpaRepository<Relleno, Long> {
}
