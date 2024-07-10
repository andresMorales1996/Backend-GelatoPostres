package com.gelato.controllers;

import com.gelato.models.Sabor;
import com.gelato.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sabor/v1")
public class SaborController {

  @Autowired
  private SaborService saborService;


  @PostMapping("/crearsabor")
  public Sabor addSabor(@RequestBody Sabor nuevoSabor) {
    return  saborService.addSabor(nuevoSabor);
  }
  @GetMapping("/todoslosabores")
  public List<Sabor> getAllSabor(){
    return  saborService.getAllSabor();
  }

  @GetMapping("/sabor/{id}")
  public Sabor getSabor(@PathVariable Long id){
    return saborService.getSabor(id);
  }

  @DeleteMapping("/deletesabor/{id}")
  public void deleteSabor(@PathVariable Long id){
    saborService.deleteSabor(id);
  }

  @PutMapping("/actualizarsabor/{id}")
  public Sabor updateSabor(@PathVariable Long id, @RequestBody Sabor actualizado) {
    return saborService.updateProducto(id,actualizado);
  }

}