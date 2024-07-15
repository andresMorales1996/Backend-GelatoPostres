package com.gelato.controllers;

import com.gelato.models.Roles;
import com.gelato.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles/v1")
public class RolesController {
  @Autowired
  private RolesService rolesService;

  @GetMapping("/allRoles")
  public List<Roles> obtenerTodosRoles() {
    return rolesService.getAllRoles();
  }

  @GetMapping("/rol/{id}")
  public ResponseEntity<Roles> obtenerRolPorId(@PathVariable Long id) {
    Roles roles = rolesService.getRol(id);
    if (roles != null) {
      return ResponseEntity.ok(roles);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/createRol")
  public ResponseEntity<Roles> crearRol(@RequestBody Roles roles) {
    Roles nuevoRoles = rolesService.createRol(roles);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRoles);
  }

  @PutMapping("/updateRol/{id}")
  public ResponseEntity<Roles> modificarRol(@PathVariable Long id, @RequestBody Roles roles) {
    Roles rolesExistente = rolesService.getRol(id);
    if (rolesExistente != null) {
      roles.setID_rol(id);
      rolesService.createRol(roles);
      return ResponseEntity.ok(roles);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/deleteRol/{id}")
  public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
    Roles roles = rolesService.getRol(id);
    if (roles != null) {
      rolesService.deleteRol(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
