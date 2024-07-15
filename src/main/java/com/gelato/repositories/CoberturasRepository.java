package com.gelato.repositories;

import com.gelato.models.Coberturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoberturasRepository extends JpaRepository<Coberturas, Long> {
}
