package com.gelato.services;

import com.gelato.models.Sabores;
import com.gelato.repositories.SaboresRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaboresService {

  @Autowired
  private SaboresRepository saboresRepository;

  // MÉTODO LISTAR SABORES
  public List<Sabores> getAllSabores() {
    return saboresRepository.findAll();
  }

  // MÉTODO BUSCAR SABOR POR ID
  public Sabores getSabor(Long id) {
    return saboresRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sabor no encontrado, intente con otro"));
  }

  // MÉTODO AGREGAR SABOR
  public Sabores createSabor(Sabores nuevoSabores) {
    return saboresRepository.save(nuevoSabores);
  }

  // MÉTODO ACTUALIZAR SABOR
  public Sabores updateSabor(Long id, Sabores update) {

    Sabores actualizarS = saboresRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sabor no encontrado, no es posible actualizarlo"));

    actualizarS.setNombre_sabor(update.getNombre_sabor());
    actualizarS.setPrecio_sabor(update.getPrecio_sabor());

    return saboresRepository.save(actualizarS);
  }

  // MÉTODO ELIMINAR SABOR
  public void deleteSabor(Long id) {
    Sabores eliminar = saboresRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sabor no encontrado, no es posible eliminarlo"));
    saboresRepository.delete(eliminar);
  }
}