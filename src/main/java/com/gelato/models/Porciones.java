package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "porciones")
public class Porciones {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_porcion")
  private Long idPorcion;

  @Column(name = "nombre_porcion", nullable = false)
  private String nombrePorcion;

  @Column(name = "precio_porcion", nullable = false)
  private double precioPorcion;

}
