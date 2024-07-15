package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sabores")
public class Sabores {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_sabor")
  private Long ID_sabor;

  @Column(name = "nombre_sabor", nullable = false)
  private String nombre_sabor;

  @Column(name = "precio_sabor", nullable = false)
  private String precio_sabor;

}
