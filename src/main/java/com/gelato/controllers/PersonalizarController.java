package com.gelato.controllers;

import com.gelato.models.Personalizar;
import com.gelato.services.PersonalizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalizar")
public class PersonalizarController {

    @Autowired
    private PersonalizarService personalizar;

    @GetMapping
    public List<Personalizar> getAllPersonalizar() {
      return PersonalizarService.getAllPersonalizar();
    }

    @GetMapping("/{id}")
    public Personalizar getPersonalizarById(@PathVariable Long id) {
      return PersonalizarService.getPersonalizarById(id);
    }

    @PostMapping
    public Personalizar addPersonalizar(@RequestBody Personalizar Personalizar) {
      return PersonalizarService.addPersonalizar(Personalizar);
    }

    @PutMapping("/{id}")
    public Personalizar updatePersonalizar(@PathVariable Long id, @RequestBody Personalizar PersonalizarDetails) {
      return PersonalizarService.updatePersonalizar(id, PersonalizarDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePersonalizar(@PathVariable Long id) {
      PersonalizarService.deletePersonalizar(id);
    }
  }}
