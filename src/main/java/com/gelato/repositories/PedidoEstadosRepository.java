package com.gelato.repositories;

import com.gelato.models.PedidoEstados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoEstadosRepository extends JpaRepository<PedidoEstados, Long> {
}