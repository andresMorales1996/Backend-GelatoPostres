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

  // MÉTODO LISTAR COBERTURAS
  public List<Coberturas> getAllCoberturas() {
    return coberturasRepository.findAll();
  }

  // MÉTODO BUSCA COBERTURA POR ID
  public Coberturas getCobertura(Long id) {
    return coberturasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cobertura no encontrada, intente con otro"));
  }

  // MÉTODO AGREGAR COBERTURA
  public Coberturas createCobertura(Coberturas nuevoCoberturas) {
    return coberturasRepository.save(nuevoCoberturas);
  }

  // MÉTODO ACTUALIZAR COBERTURA

  public Coberturas updateCobertura(Long id, Coberturas update) {

    Coberturas actualizarC = coberturasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cobertura no encontrada, no es posible actualizarlo"));

    actualizarC.setNombre_cobertura(update.getNombre_cobertura());

    return coberturasRepository.save(actualizarC);
  }

  // MÉTODO ELIMINAR COBERTURA
  public void deleteCobertura(Long id) {
    Coberturas eliminar = coberturasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cobertura no encontrada, no es posible eliminarlo"));
    coberturasRepository.delete(eliminar);
  }
}
