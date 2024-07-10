package com.gelato.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "toppings")
public class Toppings {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id_toppings;
  @Column( name = "nombre_topping", nullable = false)
  private String nombre_toppings;

  @OneToOne
  @JoinColumn( name = "personalizar_id")
  private Personalizar personalizar;
}