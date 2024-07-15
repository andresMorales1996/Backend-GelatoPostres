package com.gelato.services;

import com.gelato.models.Usuarios;
import com.gelato.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

  @Autowired
  private static UsuariosRepository usuariosRepository;

  // MÉTODO LISTAR USUARIOS
  public List<Usuarios> getAllUsuarios() {
    return usuariosRepository.findAll();
  }

  // MÉTODO BUSCAR USUARIO POR ID
  public static Usuarios getUsuario(Long id) {
    return usuariosRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR USUARIO
  public Usuarios createUsuario(Usuarios usuarios) {
    return usuariosRepository.save(usuarios);
  }

  // MÉTODO ACTUALIZAR USUARIO
  public static Usuarios updateUsuario(Long id, Usuarios update) {
    Usuarios usuario = getUsuario(id);

    if (usuario != null) {
      usuario.setNombre_usuario(update.getNombre_usuario());
      usuario.setTelefono_usuario(update.getTelefono_usuario());
      usuario.setEmail_usuario(update.getEmail_usuario());
      usuario.setContrasena_usuario(update.getContrasena_usuario());
      usuario.setGenero_usuario(update.getGenero_usuario());
      usuario.setImagen_usuario(update.getImagen_usuario());
      return usuariosRepository.save(usuario);
    } else {
      return null;
    }
  }

  // MÉTODO ELIMINAR USUARIO  
  public void deleteUsuario(Long id) {
    usuariosRepository.deleteById(id);
  }

}
