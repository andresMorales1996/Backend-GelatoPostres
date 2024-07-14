package com.gelato.controllers;

import com.gelato.models.Toppings;
import com.gelato.services.ToppingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings/v1")
public class ToppingsController {

  @Autowired
  private ToppingsService toppingsService;

  @GetMapping("/allToppings")
  public List<Toppings> getAllToppings(){
    return  toppingsService.getAllToppings();
  }

  @GetMapping("/toppings/{id}")
  public Toppings getToppings(@PathVariable Long id){
    return toppingsService.getToppings(id);
  }

  @PostMapping("/createToppings")
  public Toppings addToppings(@RequestBody Toppings nuevoTopping) {
    return  toppingsService.addToppings(nuevoTopping);
  }

  @PutMapping("/updateToppings/{id}")
  public Toppings updateToppings(@PathVariable Long id, @RequestBody Toppings actualizado) {
    return toppingsService.updateProducto(id,actualizado);
  }
  @DeleteMapping("/deleteToppings/{id}")
  public void deleteToppings(@PathVariable Long id){
    toppingsService.deleteToppings(id);
  }
}