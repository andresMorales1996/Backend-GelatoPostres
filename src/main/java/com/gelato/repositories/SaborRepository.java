package com.gelato.repositories;

import com.gelato.models.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository <Sabor, Long> {
}
