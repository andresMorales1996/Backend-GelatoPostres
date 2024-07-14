package com.gelato.controllers;

import com.gelato.models.PedidoDetalles;
import com.gelato.services.PedidoDetallesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido-detalles")
public class PedidoDetallesController {

  @Autowired
  private PedidoDetallesService pedidoDetallesService;

  @GetMapping
  public List<PedidoDetalles> getAllPedidoDetalles() {
    return pedidoDetallesService.getAllPedidoDetalles();
  }

  @GetMapping("/{id}")
  public PedidoDetalles getPedidoDetalleById(@PathVariable Long id) {
    return pedidoDetallesService.getPedidoDetalleById(id);
  }

  @PostMapping("/add")
  public PedidoDetalles addPedidoDetalle(@RequestBody PedidoDetalles pedidoDetalle) {
    return pedidoDetallesService.addPedidoDetalle(pedidoDetalle);
  }

  @PutMapping("/{id}")
  public PedidoDetalles updatePedidoDetalle(@PathVariable Long id, @RequestBody PedidoDetalles pedidoDetalleDetails) {
    return pedidoDetallesService.updatePedidoDetalle(id, pedidoDetalleDetails);
  }

  @DeleteMapping("/{id}")
  public void deletePedidoDetalle(@PathVariable Long id) {
    pedidoDetallesService.deletePedidoDetalle(id);
  }
}