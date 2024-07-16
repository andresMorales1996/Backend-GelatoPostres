package com.gelato.controllers;

import com.gelato.models.Usuarios;
import com.gelato.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/v1")
public class UsuariosController {

  @Autowired
  private UsuariosService usuariosService;

  @GetMapping("/allUsuarios")
  public List<Usuarios> getAllUsuarios() {
    return usuariosService.getAllUsuarios();
  }

  @GetMapping("/usuario/{id}")
  public Usuarios getUsuario(@PathVariable Long id) {
    return usuariosService.getUsuario(id);
  }

  @PostMapping("/createUsuario")
  public Usuarios createUsuario(@RequestBody Usuarios usuarios) {
    return usuariosService.createUsuario(usuarios);
  }

  @PutMapping("/updateUsuario/{id}")
  public Usuarios updateUsuario(@PathVariable Long id, @RequestBody Usuarios Usuarios) {
    return UsuariosService.updateUsuario(id, Usuarios);
  }

  @DeleteMapping("/deleteUsuario/{id}")
  public void deleteUsuario(@PathVariable Long id) {
    usuariosService.deleteUsuario(id);
  }

}
