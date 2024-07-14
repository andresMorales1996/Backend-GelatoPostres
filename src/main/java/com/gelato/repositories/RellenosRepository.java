package com.gelato.repositories;

import com.gelato.models.Rellenos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RellenosRepository extends JpaRepository<Rellenos, Long> {
}
