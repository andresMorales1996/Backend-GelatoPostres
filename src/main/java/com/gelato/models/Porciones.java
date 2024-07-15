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
  private Long ID_porcion;

  @Column(name = "nombre_porcion", nullable = false)
  private String nombre_porcion;

  @Column(name = "precio_porcion", nullable = false)
  private double precio_porcion;

}
