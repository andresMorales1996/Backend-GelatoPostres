package com.gelato.services;

import com.gelato.models.EstadoPago;
import com.gelato.repositories.EstadoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPagoService {

  @Autowired
  private EstadoPagoRepository estadoPagoRepository;

  public List<EstadoPago> getAllEstadosPago() {
    return estadoPagoRepository.findAll();
  }

  public EstadoPago getEstadoPagoById(Long id) {
    return estadoPagoRepository.findById(id).orElse(null);
  }

  public EstadoPago addEstadoPago(EstadoPago estadoPago) {
    return estadoPagoRepository.save(estadoPago);
  }

  public EstadoPago updateEstadoPago(Long id, EstadoPago estadoPagoDetails) {
    EstadoPago estadoPago = estadoPagoRepository.findById(id).orElse(null);
    if (estadoPago != null) {
      estadoPago.setNombre_estado_pago(estadoPagoDetails.getNombre_estado_pago());
      return estadoPagoRepository.save(estadoPago);
    }
    return null;
  }

  public void deleteEstadoPago(Long id) {
    estadoPagoRepository.deleteById(id);
  }
}