package com.gelato.controllers;

import com.gelato.models.Categorias;
import com.gelato.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public List<Categorias> getAllCategoria() {
        return categoriasService.getAllCategoria();
    }

    @PostMapping("/add")
    public Categorias addCategoria(@RequestBody Categorias categorias) {
        return categoriasService.addCategoria(categorias);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id){
        categoriasService.deleteCategoria(id);
    }

    @GetMapping("/{id}")
    public Categorias findCategoria(@PathVariable Long id){
        return categoriasService.findCategoria(id);
    }

    @PutMapping("/{id}")
    public Categorias updateCategoria(@PathVariable Long id, @RequestBody Categorias categorias) {
        return categoriasService.updateCategoria(id, categorias);
    }
}
