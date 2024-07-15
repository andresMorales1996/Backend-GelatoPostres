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
  public List<Toppings> getAllToppings() {
    return toppingsService.getAllToppings();
  }

  @GetMapping("/topping/{id}")
  public Toppings getTopping(@PathVariable Long id) {
    return toppingsService.getToppings(id);
  }

  @PostMapping("/createTopping")
  public Toppings createTopping(@RequestBody Toppings nuevoTopping) {
    return toppingsService.createTopping(nuevoTopping);
  }

  @PutMapping("/updateTopping/{id}")
  public Toppings updateTopping(@PathVariable Long id, @RequestBody Toppings actualizado) {
    return toppingsService.updateTopping(id, actualizado);
  }

  @DeleteMapping("/deleteTopping/{id}")
  public void deleteTopping(@PathVariable Long id) {
    toppingsService.deleteTopping(id);
  }

}
