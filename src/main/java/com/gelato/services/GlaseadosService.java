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

  //Agregar nuevo Glaseado
  public Glaseados addGlaseado(Glaseados nuevoGlaseado){
    return glaseadosRepository.save(nuevoGlaseado);
  }

  // metodo para mostar todos los glaseados
  public List<Glaseados> getAllGlaseados(){
    return  glaseadosRepository.findAll();
  }

  // metodo para mostar un glaseado en especifico y ver si existe
  public Glaseados getGlaseado(Long id){
    return  glaseadosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Glaseado no encontrado, intente con otro"));
  }

  // metodo para eliminar un claseado
  public void deleteGlaseado(Long id){
  Glaseados eliminar =  glaseadosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Glaseado no encontrado, no es posible eliminarlo"));
    glaseadosRepository.delete(eliminar);
  }
 //metodo para actualzar un glaseado

  public Glaseados updateProducto(Long id, Glaseados update){

    Glaseados actualizar =  glaseadosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Glaseado no encontrado, no es posible actualizarlo"));

      actualizar.setNombre_glaseado(update.getNombre_glaseado());
      actualizar.setPrecio_glaseados(update.getPrecio_glaseados());

      return glaseadosRepository.save(actualizar);
  }
}