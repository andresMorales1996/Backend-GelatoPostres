package com.gelato.services;

import com.gelato.models.MetodoPagos;
import com.gelato.repositories.MetodoPagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoService {

  @Autowired
  private MetodoPagosRepository metodoPagosRepository;

  public List<MetodoPagos> getAllMetodosPago() {
    return metodoPagosRepository.findAll();
  }

  public MetodoPagos getMetodoPagoById(Long id) {
    return metodoPagosRepository.findById(id).orElse(null);
  }

  public MetodoPagos addMetodoPago(MetodoPagos metodoPagos) {
    return metodoPagosRepository.save(metodoPagos);
  }

  public MetodoPagos updateMetodoPago(Long id, MetodoPagos metodoPagosDetails) {
    MetodoPagos metodoPagos = metodoPagosRepository.findById(id).orElse(null);
    if (metodoPagos != null) {
      metodoPagos.setNombre_metodo_pago(metodoPagosDetails.getNombre_metodo_pago());
      return metodoPagosRepository.save(metodoPagos);
    }
    return null;
  }

  public void deleteMetodoPago(Long id) {
    metodoPagosRepository.deleteById(id);
  }
}