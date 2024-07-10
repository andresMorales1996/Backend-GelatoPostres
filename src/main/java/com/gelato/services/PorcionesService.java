package com.gelato.services;

import com.gelato.models.Porciones;
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
    public List<Porciones> getAllPorciones(){
        return porcionesRepository.findAll();
    }
    // Crear porcion
    public Porciones addPorciones(Porciones porciones){
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
    public Porciones updatePorciones(Long id, Porciones updatePorcion){
        Porciones porciones = findPorciones(id);
        if(porciones != null){
            porciones.setPorcion(updatePorcion.getPorcion());
            porciones.setPrecio_porciones(updatePorcion.getPrecio_porciones());
            return porcionesRepository.save(porciones);
        } else {
            return null;
        }
    }
}
