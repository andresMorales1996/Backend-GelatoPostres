package com.gelato.services;

import com.gelato.models.Glaseados;
import com.gelato.repositories.GlaseadosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GlaseadosService {

  @Autowired
  private GlaseadosRepository glaseadosRepository;

  // MÉTODO LISTAR GLASEADOS
  public List<Glaseados> getAllGlaseados() {
    return glaseadosRepository.findAll();
  }

  // MÉTODO BUSCA GLASEADO POR ID
  public Glaseados getGlaseado(Long id) {
    return glaseadosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Glaseado no encontrado, intente con otro"));
  }

  // MÉTODO AGREGAR GLASEADO
  public Glaseados createGlaseado(Glaseados nuevoGlaseado) {
    return glaseadosRepository.save(nuevoGlaseado);
  }

  // MÉTODO ACTUALIZAR GLASEADO

  public Glaseados updateGlaseado(Long id, Glaseados update) {

    Glaseados actualizar = glaseadosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Glaseado no encontrado, no es posible actualizarlo"));

    actualizar.setNombre_glaseado(update.getNombre_glaseado());
    actualizar.setPrecio_glaseado(update.getPrecio_glaseado());

    return glaseadosRepository.save(actualizar);
  }

  // MÉTODO ELIMINAR GLASEADO
  public void deleteGlaseado(Long id) {
    Glaseados eliminar = glaseadosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Glaseado no encontrado, no es posible eliminarlo"));
    glaseadosRepository.delete(eliminar);
  }
}