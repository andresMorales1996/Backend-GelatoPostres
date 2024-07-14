package com.gelato.services;

import com.gelato.models.Usuarios;
import com.gelato.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {
  @Autowired
  private UsuariosRepository usuariosRepository;
  
  public List<Usuarios> obtenerTodosUsuarios() {
    return usuariosRepository.findAll();
  }
  
  public Usuarios obtenerUsuarioId(Long id) {
    return usuariosRepository.findById(id).orElse(null);
  }
  
  public Usuarios guardarUsuario(Usuarios usuarios) {
    return usuariosRepository.save(usuarios);
  }
  
  public void borrarUsuario(Long id) {
    usuariosRepository.deleteById(id);
  }
}
