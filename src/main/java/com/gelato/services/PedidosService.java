package com.gelato.services;

import com.gelato.models.MetodoPagos;
import com.gelato.models.Pedidos;
import com.gelato.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

  @Autowired
  private PedidosRepository pedidosRepository;

  // MÉTODO LISTAR PEDIDOS
  public List<Pedidos> getAllPedidos() {
    return pedidosRepository.findAll();
  }

  // MÉTODO BUSCAR PEDIDO POR ID
  public Pedidos getPedido(Long id) {
    return pedidosRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR PEDIDO
  public Pedidos createPedido(Pedidos pedidos) {
    return pedidosRepository.save(pedidos);
  }

  // MÉTODO ACTUALIZAR PEDIDO
  public Pedidos updatePedido(Long id, Pedidos update) {
    Pedidos pedidos = pedidosRepository.findById(id).orElse(null);
    if (pedidos != null) {
      pedidos.setFecha_pedido(update.getFecha_pedido());
      pedidos.setFecha_entrega(update.getFecha_entrega());
      pedidos.setTotal_pedido(update.getTotal_pedido());
      return pedidosRepository.save(pedidos);
    }
    return null;
  }
  // MÉTODO ELIMINAR PEDIDO  
  public void deletePedido(Long id) {
    pedidosRepository.deleteById(id);
  }

}
