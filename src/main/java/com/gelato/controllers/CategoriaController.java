package com.gelato.controllers;

import com.gelato.models.Categoria;
import com.gelato.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategoria() {
        return categoriaService.getAllCategoria();
    }

    @PostMapping
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        return categoriaService.addCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
    }

    @GetMapping("/{id}")
    public Categoria findCategoria(@PathVariable Long id){
        return categoriaService.findCategoria(id);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }
}
