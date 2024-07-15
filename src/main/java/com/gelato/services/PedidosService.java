package com.gelato.services;

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

  // MÉTODO BUSCA PEDIDO POR ID
  public Pedidos getPedido(Long id) {
    return pedidosRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR PEDIDO
  public Pedidos createPedido(Pedidos pedidos) {
    return pedidosRepository.save(pedidos);
  }

  // MÉTODO ACTUALIZAR PEDIDO

  // MÉTODO ELIMINAR PEDIDO  
  public void deletePedido(Long id) {
    pedidosRepository.deleteById(id);
  }

}
