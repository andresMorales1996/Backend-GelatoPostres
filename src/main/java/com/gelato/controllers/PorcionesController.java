package com.gelato.controllers;

import com.gelato.models.Porciones;
import com.gelato.services.PorcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/porciones/v1")
public class PorcionesController {

    @Autowired
    private PorcionesService porcionesService;

    @GetMapping("/allPorciones")
    public List<Porciones> getAllPorciones() {
        return porcionesService.getAllPorciones();
    }

    @GetMapping("/porcion/{id}")
    public Porciones getPorcion(@PathVariable Long id){
        return porcionesService.getPorcion(id);
    }

    @PostMapping("/createPorcion")
    public Porciones addPorcion(@RequestBody Porciones porciones) {
        return porcionesService.addPorcion(porciones);
    }

    @DeleteMapping("/deletePorcion/{id}")
    public void deletePorcion(@PathVariable Long id){
        porcionesService.deletePorcion(id);
    }

    @PutMapping("/{id}")
    public Porciones updatePorcion(@PathVariable Long id, @RequestBody Porciones porciones) {
        return porcionesService.updatePorcion(id, porciones);
    }
}
