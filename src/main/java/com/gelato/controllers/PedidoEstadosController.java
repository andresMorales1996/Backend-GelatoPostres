package com.gelato.controllers;

import com.gelato.models.PedidoEstados;
import com.gelato.services.PedidoEstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoEstados/v1")
public class PedidoEstadosController {

  @Autowired
  private PedidoEstadosService pedidoEstadosService;

  @GetMapping("/allPedidoEstados")
  public List<PedidoEstados> getAllEstadosPago() {
    return pedidoEstadosService.getAllEstadosPago();
  }

  @GetMapping("/pedidoEstado/{id}")
  public PedidoEstados getEstadoPagoById(@PathVariable Long id) {
    return pedidoEstadosService.getEstadoPago(id);
  }

  @PostMapping("/createEstadoPedido")
  public PedidoEstados createEstadoPago(@RequestBody PedidoEstados pedidoEstados) {
    return pedidoEstadosService.createEstadoPago(pedidoEstados);
  }

  @PutMapping("/updatePedidoEstado/{id}")
  public PedidoEstados updateEstadoPago(@PathVariable Long id, @RequestBody PedidoEstados pedidoEstadosDetails) {
    return pedidoEstadosService.updateEstadoPago(id, pedidoEstadosDetails);
  }

  @DeleteMapping("deletePedidoEstado/{id}")
  public void deleteEstadoPago(@PathVariable Long id) {
    pedidoEstadosService.deleteEstadoPago(id);
  }
}