package com.gelato.controllers;

import com.gelato.models.Usuario;
import com.gelato.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
  @Autowired
  private UsuarioService usuarioService;
  
  @GetMapping
  public List<Usuario> obtenerTodosUsuarios() {
    return usuarioService.obtenerTodosUsuarios();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable Long id) {
    Usuario usuario = usuarioService.obtenerUsuarioId(id);
    if (usuario != null) {
      return ResponseEntity.ok(usuario);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/add")
  public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
    Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Usuario> modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    Usuario usuarioExistente = usuarioService.obtenerUsuarioId(id);
    if (usuarioExistente != null) {
      usuario.setID_usuario(id);
      usuarioService.guardarUsuario(usuario);
      return ResponseEntity.ok(usuario);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
    Usuario usuario = usuarioService.obtenerUsuarioId(id);
    if (usuario != null) {
      usuarioService.borrarUsuario(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
