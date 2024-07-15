package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "toppings")
public class Toppings {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_topping;

  @Column(name = "nombre_topping", nullable = false)
  private String nombre_topping;

  @Column(name = "precio_topping", nullable = false)
  private String precio_topping;
  
}
