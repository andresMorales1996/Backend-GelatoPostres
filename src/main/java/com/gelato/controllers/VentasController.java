package com.gelato.controllers;

import com.gelato.models.Ventas;
import com.gelato.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {

  @Autowired
  private VentasService ventasService;

  @GetMapping
  public List<Ventas> getAllVentas() {
    return ventasService.getAllVentas();
  }

  @GetMapping("/{id}")
  public Ventas getVentaById(@PathVariable Long id) {
    return ventasService.getVentaById(id);
  }

  @PostMapping("/add")
  public Ventas addVenta(@RequestBody Ventas venta) {
    return ventasService.addVenta(venta);
  }

  @PutMapping("/{id}")
  public Ventas updateVenta(@PathVariable Long id, @RequestBody Ventas ventaDetails) {
    return ventasService.updateVenta(id, ventaDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteVenta(@PathVariable Long id) {
    ventasService.deleteVenta(id);
  }
}