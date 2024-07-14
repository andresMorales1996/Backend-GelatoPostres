package com.gelato.controllers;

import com.gelato.models.Pedidos;
import com.gelato.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidosController {
  @Autowired
  private PedidosService pedidosService;
  
  @GetMapping
  public List<Pedidos> obtenerTodosPedidos() {
    return pedidosService.obtenerTodosPedidos();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Pedidos> obtenerPedidoPorId(@PathVariable Long id) {
    Pedidos pedidos = pedidosService.obtenerPedidoId(id);
    if (pedidos != null) {
      return ResponseEntity.ok(pedidos);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<Pedidos> crearPedido(@RequestBody Pedidos pedidos) {
    Pedidos nuevoPedidos = pedidosService.guardarPedido(pedidos);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedidos);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Pedidos> modificarPedido(@PathVariable Long id, @RequestBody Pedidos pedidos) {
    Pedidos pedidosExistente = pedidosService.obtenerPedidoId(id);
    if (pedidosExistente != null) {
      pedidos.setID_pedido(id);
      pedidosService.guardarPedido(pedidos);
      return ResponseEntity.ok(pedidos);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
    Pedidos pedidos = pedidosService.obtenerPedidoId(id);
    if (pedidos != null) {
      pedidosService.borrarPedido(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
