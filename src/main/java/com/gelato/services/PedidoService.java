package com.gelato.services;

import com.gelato.models.Pedido;
import com.gelato.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
  @Autowired
  private PedidoRepository pedidoRepository;
  
  public List<Pedido> obtenerTodosPedidos() {
    return pedidoRepository.findAll();
  }
  
  public Pedido obtenerPedidoId(Long id) {
    return pedidoRepository.findById(id).orElse(null);
  }
  
  public Pedido guardarPedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
  }
  
  public void borrarPedido(Long id) {
    pedidoRepository.deleteById(id);
  }
}
