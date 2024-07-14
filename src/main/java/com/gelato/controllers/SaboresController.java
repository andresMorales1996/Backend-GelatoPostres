package com.gelato.controllers;

import com.gelato.models.Sabores;
import com.gelato.services.SaboresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sabor/v1")
public class SaboresController {

  @Autowired
  private SaboresService saboresService;


  @PostMapping("/crearsabor")
  public Sabores addSabor(@RequestBody Sabores nuevoSabores) {
    return  saboresService.addSabor(nuevoSabores);
  }
  @GetMapping("/todoslosabores")
  public List<Sabores> getAllSabor(){
    return  saboresService.getAllSabor();
  }

  @GetMapping("/sabor/{id}")
  public Sabores getSabor(@PathVariable Long id){
    return saboresService.getSabor(id);
  }

  @DeleteMapping("/deletesabor/{id}")
  public void deleteSabor(@PathVariable Long id){
    saboresService.deleteSabor(id);
  }

  @PutMapping("/actualizarsabor/{id}")
  public Sabores updateSabor(@PathVariable Long id, @RequestBody Sabores actualizado) {
    return saboresService.updateProducto(id,actualizado);
  }


}