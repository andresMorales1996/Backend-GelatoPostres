package com.gelato.repositories;

import com.gelato.models.Sabores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaboresRepository extends JpaRepository <Sabores, Long> {
}
