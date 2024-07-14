package com.gelato.controllers;

import com.gelato.models.Rellenos;
import com.gelato.services.RellenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rellenos/v1")
public class RellenosController {

    @Autowired
    private RellenosService rellenosService;

    @GetMapping("/allRellenos")
    public List<Rellenos> getAllRellenos() {
        return rellenosService.getAllRellenos();
    }

    @GetMapping("/relleno/{id}")
    public Rellenos getRelleno(@PathVariable Long id){
        return rellenosService.getRelleno(id);
    }

    @PostMapping("/createRelleno")
    public Rellenos addRelleno(@RequestBody Rellenos rellenos) {
        return rellenosService.addRelleno(rellenos);
    }

    @PutMapping("/actualizarRelleno/{id}")
    public Rellenos updateRelleno(@PathVariable Long id, @RequestBody Rellenos rellenos) {
        return rellenosService.updateRelleno(id, rellenos);
    }

    @DeleteMapping("/deleteRelleno/{id}")
    public void deleteRelleno(@PathVariable Long id){
        rellenosService.deleteRelleno(id);
    }




}
