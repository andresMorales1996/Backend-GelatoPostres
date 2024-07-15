package com.gelato.services;

import com.gelato.models.Coberturas;
import com.gelato.models.DireccionEntregas;
import com.gelato.repositories.DireccionEntregasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionEntregasService {

  @Autowired
  private DireccionEntregasRepository direccionEntregasRepository;

  // MÉTODO LISTAR DIRECCION ENTREGAS
  public List<DireccionEntregas> getAllDireccionEntregas() {
    return direccionEntregasRepository.findAll();
  }

  // MÉTODO BUSCAR DIRECCION ENTREGA POR ID
  public DireccionEntregas getDireccionEntrega(Long id) {
    return direccionEntregasRepository.findById(id).orElse(null);
  }

  // MÉTODO AGREGAR DIRECCIONENTREGA
  public DireccionEntregas createDireccionEntrega(DireccionEntregas direccionEntregas) {
    return direccionEntregasRepository.save(direccionEntregas);
  }

  // MÉTODO ACTUALIZAR DIRECCIONENTREGA

  public DireccionEntregas updateCobertura(Long id, DireccionEntregas update) {

    DireccionEntregas actualizarDe = direccionEntregasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Direccion de entrega no encontrada, no es posible actualizarla"));

    actualizarDe.setDireccion_entrega(update.getDireccion_entrega());

    return direccionEntregasRepository.save(actualizarDe);
  }

  // MÉTODO ELIMINAR DIRECCIONENTREGA  
  public void deleteDireccionEntrega(Long id) {
    direccionEntregasRepository.deleteById(id);
  }

}
