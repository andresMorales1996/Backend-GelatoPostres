package com.gelato.controllers;

import com.gelato.models.Categorias;
import com.gelato.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias/v1")
public class CategoriasController {

  @Autowired
  private CategoriasService categoriasService;

  @GetMapping("/allCategorias")
  public List<Categorias> getAllCategorias() {
    return categoriasService.getAllCategorias();
  }

  @GetMapping("/categoria/{id}")
  public Categorias getCategoria(@PathVariable Long id) {
    return categoriasService.getCategoria(id);
  }

  @PostMapping("/createCategoria")
  public Categorias createCategoria(@RequestBody Categorias categorias) {
    return categoriasService.createCategoria(categorias);
  }

  @PutMapping("/updateCategoria/{id}")
  public Categorias updateCategoria(@PathVariable Long id, @RequestBody Categorias categorias) {
    return categoriasService.updateCategoria(id, categorias);
  }

  @DeleteMapping("/deleteCategoria/{id}")
  public void deleteCategoria(@PathVariable Long id) {
    categoriasService.deleteCategoria(id);
  }

}
