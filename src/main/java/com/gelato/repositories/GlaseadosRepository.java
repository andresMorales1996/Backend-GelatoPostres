package com.gelato.repositories;

import com.gelato.models.Glaseados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlaseadosRepository extends JpaRepository <Glaseados, Long> {
}
