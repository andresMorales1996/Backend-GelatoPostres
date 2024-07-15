package com.gelato.repositories;

import com.gelato.models.Personalizar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalizarRepository extends JpaRepository<Personalizar, Long> {
}
