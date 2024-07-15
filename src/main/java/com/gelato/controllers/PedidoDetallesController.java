package com.gelato.controllers;

import com.gelato.models.PedidoDetalles;
import com.gelato.services.PedidoDetallesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoDetalles/v1")
public class PedidoDetallesController {

  @Autowired
  private PedidoDetallesService pedidoDetallesService;

  @GetMapping("allPedidoDetalles")
  public List<PedidoDetalles> getAllPedidoDetalles() {
    return pedidoDetallesService.getAllPedidoDetalles();
  }

  @GetMapping("/pedidoDetalle/{id}")
  public PedidoDetalles getPedidoDetalleById(@PathVariable Long id) {
    return pedidoDetallesService.getPedidoDetalleById(id);
  }

  @PostMapping("/createPedidoDetalle")
  public PedidoDetalles createPedidoDetalle(@RequestBody PedidoDetalles pedidoDetalle) {
    return pedidoDetallesService.createPedidoDetalle(pedidoDetalle);
  }

  @PutMapping("/updatePedidoDetalle/{id}")
  public PedidoDetalles updatePedidoDetalle(@PathVariable Long id, @RequestBody PedidoDetalles pedidoDetalleDetails) {
    return pedidoDetallesService.updatePedidoDetalle(id, pedidoDetalleDetails);
  }

  @DeleteMapping("/deletePedidoDetalle/{id}")
  public void deletePedidoDetalle(@PathVariable Long id) {
    pedidoDetallesService.deletePedidoDetalle(id);
  }
}