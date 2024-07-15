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

  // MÉTODO LISTAR PERSONALIZAR
  public List<Personalizar> getAllPersonalizar() {
    return personalizarRepository.findAll();
  }

  // MÉTODO BUSCAR PERSONALIZAR POR ID
  public Personalizar getPersonalizar(Long id) {
    return personalizarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personalizar no encontrado, intente con otro"));
  }

  // MÉTODO AGREGAR PERSONALIZAR
  public Personalizar createPersonalizar(Personalizar nuevoPersonalizar) {
    return personalizarRepository.save(nuevoPersonalizar);
  }

  // MÉTODO ACTUALIZAR PERSONALIZAR
  public Personalizar updatePersonalizar(Long id, Personalizar update) {

    Personalizar actualizarP = personalizarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personalizar no encontrado, no es posible actualizarlo"));

    actualizarP.setImagen_personalizar(update.getImagen_personalizar());
    actualizarP.setAdicionales_personalizar(update.getAdicionales_personalizar());

    return personalizarRepository.save(actualizarP);
  }

  // MÉTODO ELIMINAR PERSONALIZAR
  public void deletePersonalizar(Long id) {
    Personalizar eliminar = personalizarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personalizar no encontrado, no es posible eliminarlo"));
    personalizarRepository.delete(eliminar);
  }

}
