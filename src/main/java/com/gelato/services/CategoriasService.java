package com.gelato.services;

import com.gelato.models.Categorias;
import com.gelato.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {
    // inyección de dependencia
    @Autowired
    private CategoriasRepository categoriasRepository;

    // Obtener todas las categorias existentes
    public List<Categorias> getAllCategoria(){
        return categoriasRepository.findAll();
    }
    // Crear categoria
    public Categorias addCategoria(Categorias categorias){
        return categoriasRepository.save(categorias);
    }
    // Eliminar categoria
    public void deleteCategoria(Long id){
        categoriasRepository.deleteById(id);
    }
    // Obtener una categoria por id
    public Categorias findCategoria(Long id) {
        return categoriasRepository.findById(id).orElse(null);
    }
    // Actualizar una categoria
    public Categorias updateCategoria(Long id, Categorias updateCategorias){
        Categorias categorias = findCategoria(id);
        if(categorias != null){
            categorias.setNombre_categoria(updateCategorias.getNombre_categoria());
            return categoriasRepository.save(categorias);
        } else {
            return null;
        }
    }
}
