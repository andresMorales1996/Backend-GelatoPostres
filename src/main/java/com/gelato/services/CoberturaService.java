package com.gelato.services;

import com.gelato.models.Cobertura;
import com.gelato.repositories.CoberturaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CoberturaService {
  @Autowired
  private CoberturaRepository coberturaRepository;

  //Agregar nuevo Cobertura
  public Cobertura addCobertura(Cobertura nuevoCobertura){
    return coberturaRepository.save(nuevoCobertura);
  }

  // metodo para mostar todos los Cobertura
  public List<Cobertura> getAllCobertura(){
    return  coberturaRepository.findAll();
  }

  // metodo para mostar una Cobertura en especifico y ver si existe
  public Cobertura getCobertura(Long id){
    return  coberturaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, intente con otro"));
  }

  // metodo para eliminar una Cobertura
  public void deleteCobertura(Long id){
    Cobertura eliminar =  coberturaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, no es posible eliminarlo"));
    coberturaRepository.delete(eliminar);
  }
  //metodo para actualizar una Cobertura

  public Cobertura updateProducto(Long id, Cobertura update){

    Cobertura actualizarC =  coberturaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, no es posible actualizarlo"));

      actualizarC.setNombre_cobertura(update.getNombre_cobertura());

      return coberturaRepository.save(actualizarC);
  }
}
