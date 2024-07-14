package com.gelato.services;

import com.gelato.models.Roles;
import com.gelato.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
  @Autowired
  private RolesRepository rolesRepository;
  
  public List<Roles> obtenerTodosRoles() {
    return rolesRepository.findAll();
  }
  
  public Roles obtenerRolId(Long id) {
    return rolesRepository.findById(id).orElse(null);
  }
  
  public Roles guardarRol(Roles roles) {
    return rolesRepository.save(roles);
  }
  
  public void borrarRol(Long id) {
    rolesRepository.deleteById(id);
  }
}
