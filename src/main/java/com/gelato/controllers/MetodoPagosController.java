package com.gelato.controllers;

import com.gelato.models.MetodoPagos;
import com.gelato.services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodo-pago/v1")
public class MetodoPagosController {

  @Autowired
  private MetodoPagoService metodoPagoService;

  @GetMapping("AllPayMethods")
  public List<MetodoPagos> getAllMetodosPago() {
    return metodoPagoService.getAllMetodosPago();
  }

  @GetMapping("/PayMethod{id}")
  public MetodoPagos getMetodoPagoById(@PathVariable Long id) {
    return metodoPagoService.getMetodoPagoById(id);
  }

  @PostMapping("/createPayMethod")
  public MetodoPagos addMetodoPago(@RequestBody MetodoPagos metodoPagos) {
    return metodoPagoService.addMetodoPago(metodoPagos);
  }

  @PutMapping("/updatePayMethod/{id}")
  public MetodoPagos updateMetodoPago(@PathVariable Long id, @RequestBody MetodoPagos metodoPagosDetails) {
    return metodoPagoService.updateMetodoPago(id, metodoPagosDetails);
  }

  @DeleteMapping("/deletePayMethod/{id}")
  public void deleteMetodoPago(@PathVariable Long id) {
    metodoPagoService.deleteMetodoPago(id);
  }
}