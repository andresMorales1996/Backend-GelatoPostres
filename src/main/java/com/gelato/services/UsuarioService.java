package com.gelato.services;

import com.gelato.models.Usuario;
import com.gelato.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;
  
  public List<Usuario> obtenerTodosUsuarios() {
    return usuarioRepository.findAll();
  }
  
  public Usuario obtenerUsuarioId(Long id) {
    return usuarioRepository.findById(id).orElse(null);
  }
  
  public Usuario guardarUsuario(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }
  
  public void borrarUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }
}
