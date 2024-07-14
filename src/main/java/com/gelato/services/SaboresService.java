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


  // metodo para mostar todos los Sabores
  public List<Sabores> getAllSabores(){
    return  saboresRepository.findAll();
  }

  // metodo para mostar un Sabor en especifico y ver si existe
  public Sabores getSabor(Long id){
    return  saboresRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sabor no encontrado, intente con otro"));
  }

  //Agregar nuevo sabor
  public Sabores addSabor(Sabores nuevoSabores){
    return saboresRepository.save(nuevoSabores);
  }

  //metodo para actualizar un Sabor

  public Sabores updateSabor(Long id, Sabores update){

    Sabores actualizarS =  saboresRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sabor no encontrado, no es posible actualizarlo"));

    actualizarS.setNombre_sabor(update.getNombre_sabor());
    actualizarS.setDescripcion_sabor(update.getDescripcion_sabor());

    return saboresRepository.save(actualizarS);
  }

  // metodo para eliminar un sabor
  public void deleteSabor(Long id){
    Sabores eliminar =  saboresRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sabor no encontrado, no es posible eliminarlo"));
    saboresRepository.delete(eliminar);
  }
}