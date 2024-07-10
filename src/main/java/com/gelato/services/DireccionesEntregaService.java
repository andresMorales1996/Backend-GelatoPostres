package com.gelato.services;

import com.gelato.models.DireccionesEntrega;
import com.gelato.repositories.DireccionesEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionesEntregaService {
  @Autowired
  private DireccionesEntregaRepository direccionesEntregaRepository;
  
  public List<DireccionesEntrega> obtenerDireccionesEntrega() {
    return direccionesEntregaRepository.findAll();
  }
  
  public DireccionesEntrega obtenerDireccionesEntregaId(Long id) {
    return direccionesEntregaRepository.findById(id).orElse(null);
  }
  
  public DireccionesEntrega guardarDireccionesEntrega(DireccionesEntrega direccionesEntrega) {
    return direccionesEntregaRepository.save(direccionesEntrega);
  }
  
  public void borrarDireccionesEntrega(Long id) {
    direccionesEntregaRepository.deleteById(id);
  }
}
