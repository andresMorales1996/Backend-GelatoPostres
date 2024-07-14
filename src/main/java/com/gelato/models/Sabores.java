package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sabor")
public class Sabores {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_sabor;

  @Column(name = "nombre_sabor", nullable = false)
  private String nombre_sabor;

  @Column(name = "descripcion_sabor", nullable = false)
  private String descripcion_sabor;


  //  RELACIONES
//  @OneToOne
//  @JoinColumn( name = "personalizar_id")
//  private Personalizar personalizar;
//
//  @OneToOne( mappedBy = "sabor")
//  private Personalizar personalizarSabor;
}

