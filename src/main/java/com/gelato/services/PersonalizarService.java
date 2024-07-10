package com.gelato.services;

import com.gelato.models.Personalizar;
import com.gelato.repositories.PersonalizarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonalizarService {
  @Autowired
  private PersonalizarRepository personalizarRepository;

  //Agregar nuevo Personalizar
  public Personalizar addPersonalizar(Personalizar nuevoPersonalizar) {
    return personalizarRepository.save(nuevoPersonalizar);
  }

  // metodo para mostar todos los Personalizar
  public List<Personalizar> getAllPersonalizar() {
    return personalizarRepository.findAll();
  }

  // metodo para mostar una Personalizar en especifico y ver si existe
  public Personalizar getPersonalizar(Long id) {
    return personalizarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personalizar no encontrado, intente con otro"));
  }

  // metodo para eliminar una Personalizar
  public void deletePersonalizar(Long id) {
    Personalizar eliminar = personalizarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personalizar no encontrado, no es posible eliminarlo"));
    personalizarRepository.delete(eliminar);
  }
  //metodo para actualzar una Personalizar

  public Personalizar updateProducto(Long id, Personalizar update) {

    Personalizar actualizarP = personalizarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personalizar no encontrado, no es posible actualizarlo"));

      actualizarP.setImagen_personalizar(update.getImagen_personalizar());
      actualizarP.setAdicionales_personalizar(update.getAdicionales_personalizar());

    return personalizarRepository.save(actualizarP);
  }
}