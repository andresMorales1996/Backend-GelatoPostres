package com.gelato.services;


import com.gelato.models.Relleno;
import com.gelato.repositories.RellenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RellenoService {
    // inyección de dependencia
    @Autowired
    private RellenoRepository rellenoRepository;

    // Obtener todos los rellenos existentes
    public List<Relleno> getAllRelleno(){
        return rellenoRepository.findAll();
    }
    // Crear relleno
    public Relleno addRelleno(Relleno relleno){
        return rellenoRepository.save(relleno);
    }
    // Eliminar relleno
    public void deleteRelleno(Long id){
        rellenoRepository.deleteById(id);
    }
    // Obtener un relleno por id
    public Relleno findRelleno(Long id) {
        return rellenoRepository.findById(id).orElse(null);
    }
    // Actualizar un relleno
    public Relleno updateRelleno(Long id, Relleno updateRelleno){
        Relleno rellenos = findRelleno(id);
        if(rellenos != null){
            rellenos.setNombre_relleno(updateRelleno.getNombre_relleno());
            return rellenoRepository.save(rellenos);
        } else {
            return null;
        }
    }
}
