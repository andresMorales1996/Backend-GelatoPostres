package com.gelato.controllers;

import com.gelato.models.Rellenos;
import com.gelato.services.RellenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rellenos")
public class RellenosController {
    @Autowired
    private RellenosService rellenosService;

    @GetMapping
    public List<Rellenos> getAllRelleno() {
        return rellenosService.getAllRelleno();
    }

    @PostMapping("/add")
    public Rellenos addRelleno(@RequestBody Rellenos rellenos) {
        return rellenosService.addRelleno(rellenos);
    }

    @DeleteMapping("/{id}")
    public void deleteRelleno(@PathVariable Long id){
        rellenosService.deleteRelleno(id);
    }

    @GetMapping("/{id}")
    public Rellenos findRelleno(@PathVariable Long id){
        return rellenosService.findRelleno(id);
    }

    @PutMapping("/{id}")
    public Rellenos updateRelleno(@PathVariable Long id, @RequestBody Rellenos rellenos) {
        return rellenosService.updateRelleno(id, rellenos);
    }
}
