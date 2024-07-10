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


  @PostMapping("/crearglaseados")
  public Glaseados addGlaseados(@RequestBody Glaseados nuevoGlaseado) {
    return  glaseadosService.addGlaseado(nuevoGlaseado);
  }
  @GetMapping("/todoslosglaseados")
  public List<Glaseados> getAllGlaseados(){
    return  glaseadosService.getAllGlaseados();
  }

  @GetMapping("/glaseados/{id}")
  public Glaseados getGlaseados(@PathVariable Long id){
    return glaseadosService.getGlaseado(id);
  }

  @DeleteMapping("/deleteglaseados/{id}")
  public void deleteGlaseados(@PathVariable Long id){
    glaseadosService.deleteGlaseado(id);
  }

  @PutMapping("/actualizarglaseados/{id}")
  public Glaseados updateGlaseados(@PathVariable Long id, @RequestBody Glaseados actualizado) {
    return glaseadosService.updateProducto(id,actualizado);
  }

}