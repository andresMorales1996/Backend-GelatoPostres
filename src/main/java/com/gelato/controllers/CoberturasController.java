package com.gelato.controllers;

import com.gelato.models.Coberturas;
import com.gelato.services.CoberturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cobertura/v1")
public class CoberturasController {

  @Autowired
  private CoberturasService coberturasService;


  @PostMapping("/crearcobertura")
  public Coberturas addCobertura(@RequestBody Coberturas nuevoCoberturas) {
    return  coberturasService.addCobertura(nuevoCoberturas);
  }
  @GetMapping("/todosloscobertura")
  public List<Coberturas> getAllCobertura(){
    return  coberturasService.getAllCobertura();
  }

  @GetMapping("/cobertura/{id}")
  public Coberturas getCobertura(@PathVariable Long id){
    return coberturasService.getCobertura(id);
  }

  @DeleteMapping("/deletecobertura/{id}")
  public void deleteCobertura(@PathVariable Long id){
    coberturasService.deleteCobertura(id);
  }

  @PutMapping("/actualizarCobertura/{id}")
  public Coberturas updateCobertura(@PathVariable Long id, @RequestBody Coberturas actualizado) {
    return coberturasService.updateProducto(id,actualizado);
  }

}