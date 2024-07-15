package com.gelato.services;

import com.gelato.models.PedidoEstados;
import com.gelato.repositories.PedidoEstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoEstadosService {

  @Autowired
  private PedidoEstadosRepository pedidoEstadosRepository;

  public List<PedidoEstados> getAllEstadosPago() {
    return pedidoEstadosRepository.findAll();
  }

  public PedidoEstados getEstadoPagoById(Long id) {
    return pedidoEstadosRepository.findById(id).orElse(null);
  }

  public PedidoEstados createEstadoPago(PedidoEstados pedidoEstados) {
    return pedidoEstadosRepository.save(pedidoEstados);
  }

  public PedidoEstados updateEstadoPago(Long id, PedidoEstados pedidoEstadosDetails) {
    PedidoEstados pedidoEstados = pedidoEstadosRepository.findById(id).orElse(null);
    if (pedidoEstados != null) {
      pedidoEstados.setNombre_pedido_estado(pedidoEstadosDetails.getNombre_pedido_estado());
      return pedidoEstadosRepository.save(pedidoEstados);
    }
    return null;
  }

  public void deleteEstadoPago(Long id) {
    pedidoEstadosRepository.deleteById(id);
  }
}