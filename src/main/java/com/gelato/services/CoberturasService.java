package com.gelato.services;

import com.gelato.models.Coberturas;
import com.gelato.repositories.CoberturasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CoberturasService {
  @Autowired
  private CoberturasRepository coberturasRepository;

  //Agregar nuevo Cobertura
  public Coberturas addCobertura(Coberturas nuevoCoberturas){
    return coberturasRepository.save(nuevoCoberturas);
  }

  // metodo para mostar todos los Cobertura
  public List<Coberturas> getAllCobertura(){
    return  coberturasRepository.findAll();
  }

  // metodo para mostar una Cobertura en especifico y ver si existe
  public Coberturas getCobertura(Long id){
    return  coberturasRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, intente con otro"));
  }

  // metodo para eliminar una Cobertura
  public void deleteCobertura(Long id){
    Coberturas eliminar =  coberturasRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, no es posible eliminarlo"));
    coberturasRepository.delete(eliminar);
  }
  //metodo para actualizar una Cobertura

  public Coberturas updateProducto(Long id, Coberturas update){

    Coberturas actualizarC =  coberturasRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Cobertura no encontrada, no es posible actualizarlo"));

      actualizarC.setNombre_cobertura(update.getNombre_cobertura());

      return coberturasRepository.save(actualizarC);
  }
}
