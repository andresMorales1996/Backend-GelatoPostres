package com.gelato.controllers;

import com.gelato.models.Categoria;
import com.gelato.models.Porciones;
import com.gelato.services.CategoriaService;
import com.gelato.services.PorcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/porciones")
public class PorcionesController {
    @Autowired
    private PorcionesService porcionesService;
    @GetMapping
    public List<Porciones> getAllPorciones() {
        return porcionesService.getAllPorciones();
    }

    @PostMapping
    public Porciones addPorciones(@RequestBody Porciones porciones) {
        return porcionesService.addPorciones(porciones);
    }

    @DeleteMapping("/{id}")
    public void deletePorciones(@PathVariable Long id){
        porcionesService.deletePorciones(id);
    }

    @GetMapping("/{id}")
    public Porciones findPorciones(@PathVariable Long id){
        return porcionesService.findPorciones(id);
    }

    @PutMapping("/{id}")
    public Porciones updatePorciones(@PathVariable Long id, @RequestBody Porciones porciones) {
        return porcionesService.updatePorciones(id, porciones);
    }
}
