package com.gelato.services;

import com.gelato.models.Toppings;
import com.gelato.repositories.ToppingsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ToppingsService {

  @Autowired
  private ToppingsRepository toppingsRepository;

  // MÉTODO LISTAR TOPPINGS
  public List<Toppings> getAllToppings() {
    return toppingsRepository.findAll();
  }

  // MÉTODO BUSCAR TOPPING POR ID
  public Toppings getToppings(Long id) {
    return toppingsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topping no encontrado, intente con otro"));
  }

  // MÉTODO AGREGAR TOPPING
  public Toppings createTopping(Toppings nuevoTopping) {
    return toppingsRepository.save(nuevoTopping);
  }

  // MÉTODO ACTUALIZAR TOPPING
  public Toppings updateTopping(Long id, Toppings update) {

    Toppings actualizarT = toppingsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topping no encontrado, no es posible actualizarlo"));

    actualizarT.setNombre_topping(update.getNombre_topping());

    return toppingsRepository.save(actualizarT);

  }

  // MÉTODO ELIMINAR TOPPING
  public void deleteTopping(Long id) {
    Toppings eliminar = toppingsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topping no encontrado, no es posible eliminarlo"));
    toppingsRepository.delete(eliminar);
  }

}
