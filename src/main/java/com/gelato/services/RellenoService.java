package com.gelato.services;

import com.gelato.models.Categoria;
import com.gelato.models.Relleno;
import com.gelato.repositories.CategoriaRepository;
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
    private List<Relleno> getAllRelleno(){
        return rellenoRepository.findAll();
    }
    // Crear relleno
    private Relleno addRelleno(Relleno relleno){
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
}
