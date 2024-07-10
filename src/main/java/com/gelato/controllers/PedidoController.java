package com.gelato.controllers;

import com.gelato.models.Pedido;
import com.gelato.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
  @Autowired
  private PedidoService pedidoService;
  
  @GetMapping
  public List<Pedido> obtenerTodosPedidos() {
    return pedidoService.obtenerTodosPedidos();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
    Pedido pedido = pedidoService.obtenerPedidoId(id);
    if (pedido != null) {
      return ResponseEntity.ok(pedido);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
    Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Pedido> modificarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
    Pedido pedidoExistente = pedidoService.obtenerPedidoId(id);
    if (pedidoExistente != null) {
      pedido.setID_pedido(id);
      pedidoService.guardarPedido(pedido);
      return ResponseEntity.ok(pedido);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
    Pedido pedido = pedidoService.obtenerPedidoId(id);
    if (pedido != null) {
      pedidoService.borrarPedido(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
