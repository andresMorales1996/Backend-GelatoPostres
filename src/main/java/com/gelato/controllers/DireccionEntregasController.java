package com.gelato.controllers;

import com.gelato.models.DireccionEntregas;
import com.gelato.services.DireccionEntregasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direccion-entrega")
public class DireccionEntregasController {
  @Autowired
  private DireccionEntregasService direccionEntregasService;
  
  @GetMapping
  public List<DireccionEntregas> obtenerTodasDireccionesEntrega() {
    return direccionEntregasService.obtenerDireccionesEntrega();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<DireccionEntregas> obtenerDireccionEntregaPorId(@PathVariable Long id) {
    DireccionEntregas direccionEntrega = direccionEntregasService.obtenerDireccionesEntregaId(id);
    if (direccionEntrega != null) {
      return ResponseEntity.ok(direccionEntrega);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<DireccionEntregas> crearDireccionEntrega(@RequestBody DireccionEntregas direccionEntrega) {
    DireccionEntregas nuevaDireccionEntrega = direccionEntregasService.guardarDireccionesEntrega(direccionEntrega);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDireccionEntrega);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<DireccionEntregas> modificarDireccionEntrega(@PathVariable Long id, @RequestBody DireccionEntregas direccionEntrega) {
    DireccionEntregas direccionEntregaExistente = direccionEntregasService.obtenerDireccionesEntregaId(id);
    if (direccionEntregaExistente != null) {
      direccionEntrega.setID_direcciones_entrega(id);
      direccionEntregasService.guardarDireccionesEntrega(direccionEntrega);
      return ResponseEntity.ok(direccionEntrega);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarDireccionEntrega(@PathVariable Long id) {
    DireccionEntregas direccionEntrega = direccionEntregasService.obtenerDireccionesEntregaId(id);
    if (direccionEntrega != null) {
      direccionEntregasService.borrarDireccionesEntrega(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
