package com.gelato.controllers;

import com.gelato.models.MetodoPago;
import com.gelato.services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodo-pago")
public class MetodoPagoController {

  @Autowired
  private MetodoPagoService metodoPagoService;

  @GetMapping
  public List<MetodoPago> getAllMetodosPago() {
    return metodoPagoService.getAllMetodosPago();
  }

  @GetMapping("/{id}")
  public MetodoPago getMetodoPagoById(@PathVariable Long id) {
    return metodoPagoService.getMetodoPagoById(id);
  }

  @PostMapping("/add")
  public MetodoPago addMetodoPago(@RequestBody MetodoPago metodoPago) {
    return metodoPagoService.addMetodoPago(metodoPago);
  }

  @PutMapping("/{id}")
  public MetodoPago updateMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPagoDetails) {
    return metodoPagoService.updateMetodoPago(id, metodoPagoDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteMetodoPago(@PathVariable Long id) {
    metodoPagoService.deleteMetodoPago(id);
  }
}