package com.gelato.controllers;

import com.gelato.models.Roles;
import com.gelato.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles/v1")
public class RolesController {

  @Autowired
  private RolesService rolesService;

  @GetMapping("/allRoles")
  public List<Roles> obtenerTodosRoles() {
    return rolesService.getAllRoles();
  }

  @GetMapping("/rol/{id}")
  public Roles getRoles(@PathVariable Long id) {
    return rolesService.getRol(id);
  }

  @PostMapping("/createRol")
  public Roles createRol(@RequestBody Roles roles) {
    return rolesService.createRol(roles);
  }

  @PutMapping("/updateRol/{id}")
  public Roles updateRol(@PathVariable Long id, @RequestBody Roles roles) {
    return rolesService.updateRol(id, roles);
  }

  @DeleteMapping("/deleteRol/{id}")
  public void deleteRol(@PathVariable Long id) {
    rolesService.deleteRol(id);
  }

}
