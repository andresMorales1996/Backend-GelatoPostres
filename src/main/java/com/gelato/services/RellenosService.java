package com.gelato.services;


import com.gelato.models.Rellenos;
import com.gelato.repositories.RellenosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RellenosService {
    // inyección de dependencia
    @Autowired
    private RellenosRepository rellenosRepository;

    // Obtener todos los rellenos existentes
    public List<Rellenos> getAllRelleno(){
        return rellenosRepository.findAll();
    }
    // Crear relleno
    public Rellenos addRelleno(Rellenos rellenos){
        return rellenosRepository.save(rellenos);
    }
    // Eliminar relleno
    public void deleteRelleno(Long id){
        rellenosRepository.deleteById(id);
    }
    // Obtener un relleno por id
    public Rellenos findRelleno(Long id) {
        return rellenosRepository.findById(id).orElse(null);
    }
    // Actualizar un relleno
    public Rellenos updateRelleno(Long id, Rellenos updateRellenos){
        Rellenos rellenos = findRelleno(id);
        if(rellenos != null){
            rellenos.setNombre_relleno(updateRellenos.getNombre_relleno());
            return rellenosRepository.save(rellenos);
        } else {
            return null;
        }
    }
}
