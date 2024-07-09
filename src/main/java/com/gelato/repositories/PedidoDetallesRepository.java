package com.gelato.repositories;

import com.gelato.models.PedidoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDetallesRepository extends JpaRepository<PedidoDetalles, Long> {
}