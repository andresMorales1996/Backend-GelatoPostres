package com.gelato.services;

import com.gelato.models.Sabor;
import com.gelato.repositories.SaborRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaborService {
  @Autowired
  private SaborRepository saborRepository;

  //Agregar nuevo sabor
  public Sabor addSabor(Sabor nuevoSabor){
    return saborRepository.save(nuevoSabor);
  }

  // metodo para mostar todos los Sabor
  public List<Sabor> getAllSabor(){
    return  saborRepository.findAll();
  }

  // metodo para mostar un Sabor en especifico y ver si existe
  public Sabor getSabor(Long id){
    return  saborRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sabor no encontrado, intente con otro"));
  }

  // metodo para eliminar un claseado
  public void deleteSabor(Long id){
    Sabor eliminar =  saborRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sabor no encontrado, no es posible eliminarlo"));
    saborRepository.delete(eliminar);
  }
  //metodo para actualizar un Sabor

  public Sabor updateProducto(Long id, Sabor update){

    Sabor actualizarS =  saborRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sabor no encontrado, no es posible actualizarlo"));

      actualizarS.setNombre_sabor(update.getNombre_sabor());
      actualizarS.setDescripcion_sabor(update.getDescripcion_sabor());

      return saborRepository.save(actualizarS);
  }
}