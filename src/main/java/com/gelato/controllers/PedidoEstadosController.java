package com.gelato.controllers;

import com.gelato.models.PedidoEstados;
import com.gelato.services.PedidoEstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-pago")
public class PedidoEstadosController {

  @Autowired
  private PedidoEstadosService pedidoEstadosService;

  @GetMapping
  public List<PedidoEstados> getAllEstadosPago() {
    return pedidoEstadosService.getAllEstadosPago();
  }

  @GetMapping("/{id}")
  public PedidoEstados getEstadoPagoById(@PathVariable Long id) {
    return pedidoEstadosService.getEstadoPagoById(id);
  }

  @PostMapping("/add")
  public PedidoEstados addEstadoPago(@RequestBody PedidoEstados pedidoEstados) {
    return pedidoEstadosService.addEstadoPago(pedidoEstados);
  }

  @PutMapping("/{id}")
  public PedidoEstados updateEstadoPago(@PathVariable Long id, @RequestBody PedidoEstados pedidoEstadosDetails) {
    return pedidoEstadosService.updateEstadoPago(id, pedidoEstadosDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteEstadoPago(@PathVariable Long id) {
    pedidoEstadosService.deleteEstadoPago(id);
  }
}