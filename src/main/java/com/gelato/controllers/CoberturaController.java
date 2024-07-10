package com.gelato.controllers;

import com.gelato.models.Cobertura;
import com.gelato.services.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cobertura/v1")
public class CoberturaController {

  @Autowired
  private CoberturaService coberturaService;


  @PostMapping("/crearcobertura")
  public Cobertura addCobertura(@RequestBody Cobertura nuevoCobertura) {
    return  coberturaService.addCobertura(nuevoCobertura);
  }
  @GetMapping("/todosloscobertura")
  public List<Cobertura> getAllCobertura(){
    return  coberturaService.getAllCobertura();
  }

  @GetMapping("/cobertura/{id}")
  public Cobertura getCobertura(@PathVariable Long id){
    return coberturaService.getCobertura(id);
  }

  @DeleteMapping("/deletecobertura/{id}")
  public void deleteCobertura(@PathVariable Long id){
    coberturaService.deleteCobertura(id);
  }

  @PutMapping("/actualizarCobertura/{id}")
  public Cobertura updateCobertura(@PathVariable Long id, @RequestBody Cobertura actualizado) {
    return coberturaService.updateProducto(id,actualizado);
  }

}