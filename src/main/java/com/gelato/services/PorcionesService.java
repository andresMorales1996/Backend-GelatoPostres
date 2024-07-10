package com.gelato.services;

import com.gelato.models.Porciones;
import com.gelato.models.Relleno;
import com.gelato.repositories.CategoriaRepository;
import com.gelato.repositories.PorcionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcionesService {
    // inyección de dependencia
    @Autowired
    private PorcionesRepository porcionesRepository;

    // Obtener todas las porciones existentes
    private List<Porciones> getAllPorciones(){
        return porcionesRepository.findAll();
    }
    // Crear porcion
    private Porciones addPorciones(Porciones porciones){
        return porcionesRepository.save(porciones);
    }
    // Eliminar porcion
    public void deletePorciones(Long id){
        porcionesRepository.deleteById(id);
    }
    // Obtener una porcion por id
    public Porciones findPorciones(Long id) {
        return porcionesRepository.findById(id).orElse(null);
    }
    // Actualizar una porcion
}
