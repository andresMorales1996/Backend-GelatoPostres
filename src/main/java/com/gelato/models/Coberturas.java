package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "coberturas")
public class Coberturas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_cobertura")
  private Long ID_cobertura;

  @Column(name = "nombre_cobertura", nullable = false)
  private String nombre_cobertura;

}
