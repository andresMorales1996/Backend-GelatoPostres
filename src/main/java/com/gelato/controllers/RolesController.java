package com.gelato.controllers;

import com.gelato.models.Roles;
import com.gelato.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
  @Autowired
  private RolesService rolesService;
  
  @GetMapping
  public List<Roles> obtenerTodosRoles() {
    return rolesService.obtenerTodosRoles();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Roles> obtenerRolPorId(@PathVariable Long id) {
    Roles roles = rolesService.obtenerRolId(id);
    if (roles != null) {
      return ResponseEntity.ok(roles);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<Roles> crearRol(@RequestBody Roles roles) {
    Roles nuevoRoles = rolesService.guardarRol(roles);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRoles);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Roles> modificarRol(@PathVariable Long id, @RequestBody Roles roles) {
    Roles rolesExistente = rolesService.obtenerRolId(id);
    if (rolesExistente != null) {
      roles.setID_rol(id);
      rolesService.guardarRol(roles);
      return ResponseEntity.ok(roles);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
    Roles roles = rolesService.obtenerRolId(id);
    if (roles != null) {
      rolesService.borrarRol(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
