package com.gelato.controllers;

import com.gelato.models.Glaseados;
import com.gelato.services.GlaseadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glaseados/v1")
public class GlaseadosController {

  @Autowired
  private GlaseadosService glaseadosService;

  @GetMapping("/allGlaseados")
  public List<Glaseados> getAllGlaseados(){
    return  glaseadosService.getAllGlaseados();
  }

  @GetMapping("/glaseado/{id}")
  public Glaseados getGlaseado(@PathVariable Long id){
    return glaseadosService.getGlaseado(id);
  }

  @PostMapping("/createGlaseado")
  public Glaseados createGlaseado(@RequestBody Glaseados nuevoGlaseado) {
    return  glaseadosService.createGlaseado(nuevoGlaseado);
  }

  @PutMapping("/updateGlaseado/{id}")
  public Glaseados updateGlaseado(@PathVariable Long id, @RequestBody Glaseados actualizado) {
    return glaseadosService.updateGlaseado(id,actualizado);
  }

  @DeleteMapping("/deleteGlaseado/{id}")
  public void deleteGlaseado(@PathVariable Long id){
    glaseadosService.deleteGlaseado(id);
  }
}