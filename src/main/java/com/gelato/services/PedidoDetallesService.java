package com.gelato.services;

import com.gelato.models.PedidoDetalles;
import com.gelato.repositories.PedidoDetallesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoDetallesService {

  @Autowired
  private PedidoDetallesRepository pedidoDetallesRepository;

  public List<PedidoDetalles> getAllPedidoDetalles() {
    return pedidoDetallesRepository.findAll();
  }

  public PedidoDetalles getPedidoDetalleById(Long id) {
    return pedidoDetallesRepository.findById(id).orElse(null);
  }

  public PedidoDetalles createPedidoDetalle(PedidoDetalles pedidoDetalle) {
    return pedidoDetallesRepository.save(pedidoDetalle);
  }

  public PedidoDetalles updatePedidoDetalle(Long id, PedidoDetalles pedidoDetalleDetails) {
    PedidoDetalles pedidoDetalle = pedidoDetallesRepository.findById(id).orElse(null);
    if (pedidoDetalle != null) {
      pedidoDetalle.setCantidad(pedidoDetalleDetails.getCantidad());
      return pedidoDetallesRepository.save(pedidoDetalle);
    }
    return null;
  }

  public void deletePedidoDetalle(Long id) {
    pedidoDetallesRepository.deleteById(id);
  }
}

