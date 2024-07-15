package com.gelato.controllers;

import com.gelato.models.DireccionEntregas;
import com.gelato.services.DireccionEntregasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccionEntregas/v1")
public class DireccionEntregasController {

  @Autowired
  private DireccionEntregasService direccionEntregasService;

  @GetMapping("/allDireccionEntregas")
  public List<DireccionEntregas> obtenerTodasDireccionesEntrega() {
    return direccionEntregasService.getAllDireccionEntregas();
  }

  @GetMapping("direccionEntrega/{id}")
  public ResponseEntity<DireccionEntregas> obtenerDireccionEntregaPorId(@PathVariable Long id) {
    DireccionEntregas direccionEntrega = direccionEntregasService.getDireccionEntrega(id);
    if (direccionEntrega != null) {
      return ResponseEntity.ok(direccionEntrega);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/createDireccionEntrega")
  public ResponseEntity<DireccionEntregas> crearDireccionEntrega(@RequestBody DireccionEntregas direccionEntrega) {
    DireccionEntregas nuevaDireccionEntrega = direccionEntregasService.createDireccionEntrega(direccionEntrega);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDireccionEntrega);
  }

  @PutMapping("updateDireccionEntrega/{id}")
  public ResponseEntity<DireccionEntregas> modificarDireccionEntrega(@PathVariable Long id,
                                                                     @RequestBody DireccionEntregas direccionEntrega) {
    DireccionEntregas direccionEntregaExistente = direccionEntregasService.getDireccionEntrega(id);
    if (direccionEntregaExistente != null) {
      direccionEntrega.setID_direccion_entrega(id);
      direccionEntregasService.createDireccionEntrega(direccionEntrega);
      return ResponseEntity.ok(direccionEntrega);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/deleteDireccionEntrega/{id}")
  public ResponseEntity<Void> eliminarDireccionEntrega(@PathVariable Long id) {
    DireccionEntregas direccionEntrega = direccionEntregasService.getDireccionEntrega(id);
    if (direccionEntrega != null) {
      direccionEntregasService.deleteDireccionEntrega(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
