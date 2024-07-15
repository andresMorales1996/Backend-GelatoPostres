package com.gelato.services;


import com.gelato.models.Categorias;
import com.gelato.models.Rellenos;
import com.gelato.repositories.RellenosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RellenosService {
    // inyección de dependencia
    @Autowired
    private RellenosRepository rellenosRepository;

    // metodo para mostrar todos los rellenos
    public List<Rellenos> getAllRellenos(){
        return rellenosRepository.findAll();
    }

    // metodo para mostrar un Relleno en especifico y ver si existe
    public Rellenos getRelleno(Long id) {
        return rellenosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Relleno no encontrada, intente con otro"));
    }

    // Agregar nuevo relleno
    public Rellenos createRelleno(Rellenos rellenos){
        return rellenosRepository.save(rellenos);
    }

    // metodo para Actualizar un relleno
    public Rellenos updateRelleno(Long id, Rellenos updateRellenos){
        Rellenos rellenos = getRelleno(id);
        if(rellenos != null){
            rellenos.setNombre_relleno(updateRellenos.getNombre_relleno());
            return rellenosRepository.save(rellenos);
        } else {
            return null;
        }
    }

    // metodo para Eliminar relleno
    public void deleteRelleno(Long id){
        Rellenos eliminar =  rellenosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Relleno no encontrada, no es posible eliminarlo"));
        rellenosRepository.deleteById(id);
    }
}
