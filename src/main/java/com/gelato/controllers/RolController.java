package com.gelato.controllers;

import com.gelato.models.Rol;
import com.gelato.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {
  @Autowired
  private RolService rolService;
  
  @GetMapping
  public List<Rol> obtenerTodosRoles() {
    return rolService.obtenerTodosRoles();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
    Rol rol = rolService.obtenerRolId(id);
    if (rol != null) {
      return ResponseEntity.ok(rol);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
    Rol nuevoRol = rolService.guardarRol(rol);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Rol> modificarRol(@PathVariable Long id, @RequestBody Rol rol) {
    Rol rolExistente = rolService.obtenerRolId(id);
    if (rolExistente != null) {
      rol.setID_rol(id);
      rolService.guardarRol(rol);
      return ResponseEntity.ok(rol);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
    Rol rol = rolService.obtenerRolId(id);
    if (rol != null) {
      rolService.borrarRol(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
