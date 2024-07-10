package com.gelato.controllers;

import com.gelato.models.DireccionesEntrega;
import com.gelato.services.DireccionesEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direccion-entrega")
public class DireccionesEntregaController {
  @Autowired
  private DireccionesEntregaService direccionesEntregaService;
  
  @GetMapping
  public List<DireccionesEntrega> obtenerTodasDireccionesEntrega() {
    return direccionesEntregaService.obtenerDireccionesEntrega();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<DireccionesEntrega> obtenerDireccionEntregaPorId(@PathVariable Long id) {
    DireccionesEntrega direccionEntrega = direccionesEntregaService.obtenerDireccionesEntregaId(id);
    if (direccionEntrega != null) {
      return ResponseEntity.ok(direccionEntrega);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<DireccionesEntrega> crearDireccionEntrega(@RequestBody DireccionesEntrega direccionEntrega) {
    DireccionesEntrega nuevaDireccionEntrega = direccionesEntregaService.guardarDireccionesEntrega(direccionEntrega);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDireccionEntrega);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<DireccionesEntrega> modificarDireccionEntrega(@PathVariable Long id, @RequestBody DireccionesEntrega direccionEntrega) {
    DireccionesEntrega direccionEntregaExistente = direccionesEntregaService.obtenerDireccionesEntregaId(id);
    if (direccionEntregaExistente != null) {
      direccionEntrega.setID_direcciones_entrega(id);
      direccionesEntregaService.guardarDireccionesEntrega(direccionEntrega);
      return ResponseEntity.ok(direccionEntrega);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarDireccionEntrega(@PathVariable Long id) {
    DireccionesEntrega direccionEntrega = direccionesEntregaService.obtenerDireccionesEntregaId(id);
    if (direccionEntrega != null) {
      direccionesEntregaService.borrarDireccionesEntrega(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
