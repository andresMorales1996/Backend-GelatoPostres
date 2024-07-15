package com.gelato.controllers;

import com.gelato.models.Pedidos;
import com.gelato.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/v1")
public class PedidosController {

  @Autowired
  private PedidosService pedidosService;

  @GetMapping("/allPedidos")
  public List<Pedidos> getAllPedido() {
    return pedidosService.getAllPedidos();
  }

  @GetMapping("/pedido/{id}")
  public ResponseEntity<Pedidos> getPedido(@PathVariable Long id) {
    Pedidos pedidos = pedidosService.getPedido(id);
    if (pedidos != null) {
      return ResponseEntity.ok(pedidos);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/createPedido")
  public ResponseEntity<Pedidos> createPedido(@RequestBody Pedidos pedidos) {
    Pedidos nuevoPedidos = pedidosService.createPedido(pedidos);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedidos);
  }

  @PutMapping("/updatePedido/{id}")
  public ResponseEntity<Pedidos> updatePedido(@PathVariable Long id, @RequestBody Pedidos pedidos) {
    Pedidos pedidosExistente = pedidosService.getPedido(id);
    if (pedidosExistente != null) {
      pedidos.setID_pedido(id);
      pedidosService.createPedido(pedidos);
      return ResponseEntity.ok(pedidos);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/deletePedido/{id}")
  public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
    Pedidos pedidos = pedidosService.getPedido(id);
    if (pedidos != null) {
      pedidosService.deletePedido(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
