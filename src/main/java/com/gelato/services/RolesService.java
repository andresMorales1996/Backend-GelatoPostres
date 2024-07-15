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

  // MÉTODO LISTAR ROLES
  public List<Roles> getAllRoles() {
    return rolesRepository.findAll();
  }

  // MÉTODO BUSCAR ROL POR ID
  public Roles getRol(Long id) {
    return rolesRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR ROL
  public Roles createRol(Roles roles) {
    return rolesRepository.save(roles);
  }

  // MÉTODO ACTUALIZAR ROL

  // MÉTODO ELIMINAR ROL 
  public void deleteRol(Long id) {
    rolesRepository.deleteById(id);
  }

}
