package com.gelato.controllers;

import com.gelato.models.Sabores;
import com.gelato.services.SaboresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sabores/v1")
public class SaboresController {

  @Autowired
  private SaboresService saboresService;

  @GetMapping("/allSabores")
  public List<Sabores> getAllSabor(){
    return  saboresService.getAllSabores();
  }

  @GetMapping("/sabor/{id}")
  public Sabores getSabor(@PathVariable Long id){
    return saboresService.getSabor(id);
  }

  @PostMapping("/createSabor")
  public Sabores createSabor(@RequestBody Sabores nuevoSabores) {
    return saboresService.createSabor(nuevoSabores);
  }

  @PutMapping("/updateSabor/{id}")
  public Sabores updateSabor(@PathVariable Long id, @RequestBody Sabores actualizado) {
    return saboresService.updateSabor(id,actualizado);
  }

  @DeleteMapping("/deleteSabor/{id}")
  public void deleteSabor(@PathVariable Long id){
    saboresService.deleteSabor(id);
  }
}