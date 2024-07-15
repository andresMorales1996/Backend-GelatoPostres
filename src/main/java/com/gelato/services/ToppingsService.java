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

  // metodo para mostar todos los Toppings
  public List<Toppings> getAllToppings(){
    return  toppingsRepository.findAll();
  }

  // metodo para mostar un Topping en especifico y ver si existe
  public Toppings getToppings(Long id){
    return  toppingsRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Topping no encontrado, intente con otro"));
  }

  //Agregar nuevo Toppings
  public Toppings createTopping(Toppings nuevoTopping){
    return toppingsRepository.save(nuevoTopping);
  }

  //metodo para actualizar una Toppings
  public Toppings updateTopping(Long id, Toppings update){

    Toppings actualizarT =  toppingsRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Topping no encontrado, no es posible actualizarlo"));

    actualizarT.setNombre_topping(update.getNombre_topping());

    return toppingsRepository.save(actualizarT);

  }

  // metodo para eliminar un Topping
  public void deleteTopping(Long id){
    Toppings eliminar =  toppingsRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Topping no encontrado, no es posible eliminarlo"));
    toppingsRepository.delete(eliminar);
  }

}
