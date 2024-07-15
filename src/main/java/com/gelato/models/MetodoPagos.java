package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "metodo_pagos")
public class MetodoPagos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_metodo_pago")
  private Long ID_metodo_pago;

  @Column(name = "nombre_metodo_pago", nullable = false)
  private String nombre_metodo_pago;

}
