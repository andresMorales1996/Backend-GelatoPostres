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
  
  public List<DireccionEntregas> obtenerDireccionesEntrega() {
    return direccionEntregasRepository.findAll();
  }
  
  public DireccionEntregas obtenerDireccionesEntregaId(Long id) {
    return direccionEntregasRepository.findById(id).orElse(null);
  }
  
  public DireccionEntregas guardarDireccionesEntrega(DireccionEntregas direccionEntregas) {
    return direccionEntregasRepository.save(direccionEntregas);
  }
  
  public void borrarDireccionesEntrega(Long id) {
    direccionEntregasRepository.deleteById(id);
  }
}
