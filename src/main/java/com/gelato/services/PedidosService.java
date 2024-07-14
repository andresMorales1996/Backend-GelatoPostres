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
  
  public List<Pedidos> obtenerTodosPedidos() {
    return pedidosRepository.findAll();
  }
  
  public Pedidos obtenerPedidoId(Long id) {
    return pedidosRepository.findById(id).orElse(null);
  }
  
  public Pedidos guardarPedido(Pedidos pedidos) {
    return pedidosRepository.save(pedidos);
  }
  
  public void borrarPedido(Long id) {
    pedidosRepository.deleteById(id);
  }
}
