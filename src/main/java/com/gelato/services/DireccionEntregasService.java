package com.gelato.services;

import com.gelato.models.DireccionEntregas;
import com.gelato.repositories.DireccionEntregasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionEntregasService {

  @Autowired
  private DireccionEntregasRepository direccionEntregasRepository;

  // MÉTODO LISTAR DIRECCIONENTREGAS
  public List<DireccionEntregas> getAllDireccionEntregas() {

    return direccionEntregasRepository.findAll();
  }

  // MÉTODO BUSCA DIRECCIONENTREGA POR ID
  public DireccionEntregas getDireccionEntrega(Long id) {
    return direccionEntregasRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR DIRECCIONENTREGA
  public DireccionEntregas createDireccionEntrega(DireccionEntregas direccionEntregas) {
    return direccionEntregasRepository.save(direccionEntregas);
  }

  // MÉTODO ACTUALIZAR DIRECCIONENTREGA

  // MÉTODO ELIMINAR DIRECCIONENTREGA  
  public void deleteDireccionEntrega(Long id) {
    direccionEntregasRepository.deleteById(id);
  }

}
