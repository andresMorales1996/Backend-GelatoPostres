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

  // MÉTODO LISTAR PEDIDODETALLES
  public List<PedidoDetalles> getAllPedidoDetalles() {
    return pedidoDetallesRepository.findAll();
  }

  // MÉTODO BUSCAR PEDIDODETALLE POR ID
  public PedidoDetalles getPedidoDetalle(Long id) {
    return pedidoDetallesRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR PEDIDODETALLE
  public PedidoDetalles createPedidoDetalle(PedidoDetalles pedidoDetalle) {
    return pedidoDetallesRepository.save(pedidoDetalle);
  }

  // MÉTODO ACTUALIZAR PEDIDODETALLE
  public PedidoDetalles updatePedidoDetalle(Long id, PedidoDetalles pedidoDetalleDetails) {
    PedidoDetalles pedidoDetalle = pedidoDetallesRepository.findById(id).orElse(null);
    if (pedidoDetalle != null) {
      pedidoDetalle.setCantidad_producto(pedidoDetalleDetails.getCantidad_producto());
      return pedidoDetallesRepository.save(pedidoDetalle);
    }
    return null;
  }

  // MÉTODO ELIMINAR PEDIDODETALLE
  public void deletePedidoDetalle(Long id) {
    pedidoDetallesRepository.deleteById(id);
  }

}
