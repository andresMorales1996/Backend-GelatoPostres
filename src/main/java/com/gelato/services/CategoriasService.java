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

  // MÉTODO LISTAR CATEGORÍAS
  public List<Categorias> getAllCategorias() {
    return categoriasRepository.findAll();
  }

  // MÉTODO BUSCAR CATEGORÍA POR ID
  public Categorias getCategoria(Long id) {
    return categoriasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cobertura no encontrada, intente con otro"));
  }

  // MÉTODO AGREGAR CATEGORÍA
  public Categorias createCategoria(Categorias categorias) {
    return categoriasRepository.save(categorias);
  }

  // MÉTODO ACTUALIZAR CATEGORÍA
  public Categorias updateCategoria(Long id, Categorias update) {
    Categorias categorias = getCategoria(id);
    if (categorias != null) {
      categorias.setNombre_categoria(update.getNombre_categoria());
      return categoriasRepository.save(categorias);
    } else {
      return null;
    }
  }

  // MÉTODO ELIMINAR CATEGORÍA
  public void deleteCategoria(Long id) {
    Categorias eliminar = categoriasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada, no es posible eliminarlo"));
    categoriasRepository.delete(eliminar);
  }

}
