package com.gelato.services;

import com.gelato.models.Ventas;
import com.gelato.repositories.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasService {

  @Autowired
  private VentasRepository ventasRepository;

  public List<Ventas> getAllVentas() {
    return ventasRepository.findAll();
  }

  public Ventas getVentaById(Long id) {
    return ventasRepository.findById(id).orElse(null);
  }

  public Ventas addVenta(Ventas venta) {
    return ventasRepository.save(venta);
  }

  public Ventas updateVenta(Long id, Ventas ventaDetails) {
    Ventas venta = ventasRepository.findById(id).orElse(null);
    if (venta != null) {
      venta.setFecha(ventaDetails.getFecha());
      venta.setTotal_venta(ventaDetails.getTotal_venta());
      return ventasRepository.save(venta);
    }
    return null;
  }

  public void deleteVenta(Long id) {
    ventasRepository.deleteById(id);
  }
}
