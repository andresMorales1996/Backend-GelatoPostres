package com.gelato.services;

import com.gelato.models.Porciones;
import com.gelato.repositories.PorcionesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcionesService {

  @Autowired
  private PorcionesRepository porcionesRepository;

  // MÉTODO LISTAR PORCIONES
  public List<Porciones> getAllPorciones() {
    return porcionesRepository.findAll();
  }

  // MÉTODO BUSCAR PORCION POR ID
  public Porciones getPorcion(Long id) {
    return porcionesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Porcion no encontrada, intente con otro"));
  }

  // MÉTODO AGREGAR PORCION
  public Porciones createPorcion(Porciones porciones) {
    return porcionesRepository.save(porciones);
  }

  // MÉTODO ACTUALIZAR PORCION
  public Porciones updatePorcion(Long id, Porciones update) {
    Porciones porciones = getPorcion(id);
    if (porciones != null) {
      porciones.setNombre_porcion(update.getNombre_porcion());
      porciones.setPrecio_porcion(update.getPrecio_porcion());
      return porcionesRepository.save(porciones);
    } else {
      return null;
    }
  }

  // MÉTODO ELIMINAR PORCION
  public void deletePorcion(Long id) {
    Porciones eliminar = porcionesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Porcion no encontrada, no es posible eliminarlo"));
    porcionesRepository.deleteById(id);
  }

}
