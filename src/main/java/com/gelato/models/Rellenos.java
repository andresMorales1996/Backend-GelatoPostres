package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rellenos")
public class Rellenos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_relleno")
  private Long ID_relleno;

  @Column(name = "nombre_relleno", nullable = false)
  private String nombre_relleno;

  @Column(name = "precio_relleno", nullable = false)
  private double precio_relleno;
  
}
