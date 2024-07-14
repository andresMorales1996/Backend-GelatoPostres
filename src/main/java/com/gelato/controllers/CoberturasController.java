package com.gelato.controllers;

import com.gelato.models.Coberturas;
import com.gelato.services.CoberturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coberturas/v1")
public class CoberturasController {

  @Autowired
  private CoberturasService coberturasService;

  @GetMapping("/allCoberturas")
  public List<Coberturas> getAllCoberturas(){
    return  coberturasService.getAllCoberturas();
  }

  @GetMapping("/cobertura/{id}")
  public Coberturas getCobertura(@PathVariable Long id){
    return coberturasService.getCobertura(id);
  }

  @PostMapping("/createCobertura")
  public Coberturas addCobertura(@RequestBody Coberturas nuevoCoberturas) {
    return  coberturasService.addCobertura(nuevoCoberturas);
  }

  @PutMapping("/updateCobertura/{id}")
  public Coberturas updateCobertura(@PathVariable Long id, @RequestBody Coberturas actualizado) {
    return coberturasService.updateCobertura(id,actualizado);
  }

  @DeleteMapping("/deleteCobertura/{id}")
  public void deleteCobertura(@PathVariable Long id){
    coberturasService.deleteCobertura(id);
  }
}