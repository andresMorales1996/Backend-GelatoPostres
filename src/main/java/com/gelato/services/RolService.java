package com.gelato.services;

import com.gelato.models.Rol;
import com.gelato.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
  @Autowired
  private RolRepository rolRepository;
  
  public List<Rol> obtenerTodosRoles() {
    return rolRepository.findAll();
  }
  
  public Rol obtenerRolId(Long id) {
    return rolRepository.findById(id).orElse(null);
  }
  
  public Rol guardarRol(Rol rol) {
    return rolRepository.save(rol);
  }
  
  public void borrarRol(Long id) {
    rolRepository.deleteById(id);
  }
}
