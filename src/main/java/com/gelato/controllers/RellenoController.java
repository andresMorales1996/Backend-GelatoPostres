package com.gelato.controllers;

import com.gelato.models.Categoria;
import com.gelato.models.Relleno;
import com.gelato.services.RellenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rellenos")
public class RellenoController {
    @Autowired
    private RellenoService rellenoService;

    @GetMapping
    public List<Relleno> getAllRelleno() {
        return rellenoService.getAllRelleno();
    }

    @PostMapping
    public Relleno addRelleno(@RequestBody Relleno relleno) {
        return rellenoService.addRelleno(relleno);
    }

    @DeleteMapping("/{id}")
    public void deleteRelleno(@PathVariable Long id){
        rellenoService.deleteRelleno(id);
    }

    @GetMapping("/{id}")
    public Relleno findRelleno(@PathVariable Long id){
        return rellenoService.findRelleno(id);
    }

    @PutMapping("/{id}")
    public Relleno updateRelleno(@PathVariable Long id, @RequestBody Relleno relleno) {
        return rellenoService.updateRelleno(id, relleno);
    }
}
