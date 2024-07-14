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

<<<<<<< HEAD
//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "personalizar_id", nullable = false, unique = true)
//  private Personalizar personalizar;
=======
  @Column(name = "nombre_topping", nullable = false)
  private String nombre_topping;

  @Column(name = "precio_topping", nullable = false)
  private String precio_topping;

  //  RELACIONES
  //  @OneToOne
//  @JoinColumn( name = "personalizar_id")
//  private Personalizar personalizar;
//
//  @OneToOne( mappedBy = "toppings")
//  private Personalizar personalizarToppings;
>>>>>>> 5b7b1f1dec0d124a5c7918b93ef609f9483bf004
}