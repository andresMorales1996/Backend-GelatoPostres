package com.gelato.services;

import com.gelato.models.Categorias;
import com.gelato.repositories.CategoriasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepository;

    // metodo para mostrar todas las categorias
    public List<Categorias> getAllCategorias(){
        return categoriasRepository.findAll();
    }

    // metodo para mostrar una Categoria en especifico y ver si existe
    public Categorias getCategoria(Long id) {
        return categoriasRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, intente con otro"));
    }

    // Agregar nueva Categoria
    public Categorias createCategoria(Categorias categorias){
        return categoriasRepository.save(categorias);
    }

    // metodo para actualizar una Categoria
    public Categorias updateCategoria(Long id, Categorias update){
        Categorias categorias = getCategoria(id);
        if(categorias != null){
            categorias.setNombre_categoria(update.getNombre_categoria());
            return categoriasRepository.save(categorias);
        } else {
            return null;
        }
    }

    // metodo para eliminar una Categoria
    public void deleteCategoria(Long id){
        Categorias eliminar =  categoriasRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Categoria no encontrada, no es posible eliminarlo"));
        categoriasRepository.delete(eliminar);
    }

}
