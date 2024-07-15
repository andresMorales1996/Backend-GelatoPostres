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

  // MÉTODO LISTAR USUARIOS
  public List<Usuarios> getAllUsuarios() {
    return usuariosRepository.findAll();
  }

  // MÉTODO BUSCA USUARIO POR ID
  public Usuarios getUsuario(Long id) {
    return usuariosRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR USUARIO
  public Usuarios createUsuario(Usuarios usuarios) {
    return usuariosRepository.save(usuarios);
  }

  // MÉTODO ACTUALIZAR USUARIO

  // MÉTODO ELIMINAR USUARIO  
  public void deleteUsuario(Long id) {
    usuariosRepository.deleteById(id);
  }

}
