package com.gelato.controllers;

import com.gelato.models.EstadoPago;
import com.gelato.services.EstadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-pago")
public class EstadoPagoController {

  @Autowired
  private EstadoPagoService estadoPagoService;

  @GetMapping
  public List<EstadoPago> getAllEstadosPago() {
    return estadoPagoService.getAllEstadosPago();
  }

  @GetMapping("/{id}")
  public EstadoPago getEstadoPagoById(@PathVariable Long id) {
    return estadoPagoService.getEstadoPagoById(id);
  }

  @PostMapping
  public EstadoPago addEstadoPago(@RequestBody EstadoPago estadoPago) {
    return estadoPagoService.addEstadoPago(estadoPago);
  }

  @PutMapping("/{id}")
  public EstadoPago updateEstadoPago(@PathVariable Long id, @RequestBody EstadoPago estadoPagoDetails) {
    return estadoPagoService.updateEstadoPago(id, estadoPagoDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteEstadoPago(@PathVariable Long id) {
    estadoPagoService.deleteEstadoPago(id);
  }
}