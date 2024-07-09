package com.gelato.services;

import com.gelato.models.Categoria;
import com.gelato.models.Productos;
import com.gelato.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    // inyección de dependencia
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorias existentes
    private List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }
    // Crear categoria
    private Categoria addCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    // Eliminar categoria
    public void deleteCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
    // Obtener una categoria por id
    public Categoria findCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    // Actualizar una categoria
}
