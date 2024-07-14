package com.gelato.services;

import com.gelato.models.Coberturas;
import com.gelato.models.Porciones;
import com.gelato.models.Rellenos;
import com.gelato.repositories.PorcionesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcionesService {
    @Autowired
    private PorcionesRepository porcionesRepository;

    // metodo para mostrar todas las Porciones
    public List<Porciones> getAllPorciones(){
        return porcionesRepository.findAll();
    }

    // metodo para mostrar una Porcion en especifico y ver si existe
    public Porciones getPorcion(Long id) {
        return porcionesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Porcion no encontrada, intente con otro"));
    }

    //Agregar nueva Porcion
    public Porciones addPorcion(Porciones porciones){
        return porcionesRepository.save(porciones);
    }

    // meotodo para Actualizar una porcion
    public Porciones updatePorcion(Long id, Porciones update){
        Porciones porciones = getPorcion(id);
        if(porciones != null){
            porciones.setNombre_porcion(update.getNombre_porcion());
            porciones.setPrecio_porcion(update.getPrecio_porcion());
            return porcionesRepository.save(porciones);
        } else {
            return null;
        }
    }

    // metodo para Eliminar porcion
    public void deletePorcion(Long id){
        Porciones eliminar =  porcionesRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Porcion no encontrada, no es posible eliminarlo"));
        porcionesRepository.deleteById(id);
    }
}
