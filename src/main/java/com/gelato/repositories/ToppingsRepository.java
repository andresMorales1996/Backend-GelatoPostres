package com.gelato.repositories;

import com.gelato.models.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Long> {
}

