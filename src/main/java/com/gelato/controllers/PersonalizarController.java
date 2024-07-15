package com.gelato.controllers;

import com.gelato.models.Personalizar;
import com.gelato.services.PersonalizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalizar/v1")
public class PersonalizarController {

  @Autowired
  private PersonalizarService personalizarService;

  @GetMapping("/allPersonalizar")
  public List<Personalizar> getAllPersonalizar(){
    return  personalizarService.getAllPersonalizar();
  }

  @GetMapping("/personalizar/{id}")
  public Personalizar getPersonalizar(@PathVariable Long id){
    return personalizarService.getPersonalizar(id);
  }

  @PostMapping("/createPersonalizar")
  public Personalizar createPersonalizar(@RequestBody Personalizar nuevoPersonalizar) {
    return  personalizarService.createPersonalizar(nuevoPersonalizar);
  }

  @PutMapping("/updatePersonalizar/{id}")
  public Personalizar updatePersonalizar(@PathVariable Long id, @RequestBody Personalizar actualizado) {
    return personalizarService.updatePersonalizar(id,actualizado);
  }

  @DeleteMapping("/deletePersonalizar/{id}")
  public void deletePersonalizar(@PathVariable Long id){
    personalizarService.deletePersonalizar(id);
  }
}