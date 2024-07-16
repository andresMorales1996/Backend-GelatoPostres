package com.gelato.controllers;

import com.gelato.models.Usuarios;
import com.gelato.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/v1")
public class UsuariosController {
  @Autowired
  private UsuariosService usuariosService;

  @GetMapping("/allUsuarios")
  public List<Usuarios> obtenerTodosUsuarios() {
    return usuariosService.getAllUsuarios();
  }

  @GetMapping("/usuario/{id}")
  public ResponseEntity<Usuarios> obtenerUsuarioId(@PathVariable Long id) {
    Usuarios usuarios = usuariosService.getUsuario(id);
    if (usuarios != null) {
      return ResponseEntity.ok(usuarios);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/createUsuario")
  public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuarios) {
    Usuarios nuevoUsuarios = usuariosService.createUsuario(usuarios);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarios);
  }

  @PutMapping("/updateUsuario/{id}")
  public ResponseEntity<Usuarios> modificarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarios) {
    Usuarios usuariosExistente = usuariosService.getUsuario(id);
    if (usuariosExistente != null) {
      usuarios.setID_usuario(id);
      usuariosService.createUsuario(usuarios);
      return ResponseEntity.ok(usuarios);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/deleteUsuario/{id}")
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
    Usuarios usuarios = usuariosService.getUsuario(id);
    if (usuarios != null) {
      usuariosService.deleteUsuario(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
