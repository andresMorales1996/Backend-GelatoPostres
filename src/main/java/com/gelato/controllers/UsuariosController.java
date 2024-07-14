package com.gelato.controllers;

import com.gelato.models.Usuarios;
import com.gelato.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuariosController {
  @Autowired
  private UsuariosService usuariosService;
  
  @GetMapping
  public List<Usuarios> obtenerTodosUsuarios() {
    return usuariosService.obtenerTodosUsuarios();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Usuarios> obtenerUsuarioId(@PathVariable Long id) {
    Usuarios usuarios = usuariosService.obtenerUsuarioId(id);
    if (usuarios != null) {
      return ResponseEntity.ok(usuarios);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuarios) {
    Usuarios nuevoUsuarios = usuariosService.guardarUsuario(usuarios);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarios);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Usuarios> modificarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarios) {
    Usuarios usuariosExistente = usuariosService.obtenerUsuarioId(id);
    if (usuariosExistente != null) {
      usuarios.setID_usuario(id);
      usuariosService.guardarUsuario(usuarios);
      return ResponseEntity.ok(usuarios);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
    Usuarios usuarios = usuariosService.obtenerUsuarioId(id);
    if (usuarios != null) {
      usuariosService.borrarUsuario(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
