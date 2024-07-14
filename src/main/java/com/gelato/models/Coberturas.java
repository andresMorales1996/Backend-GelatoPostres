package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cobertura")
public class Coberturas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_cobertura;

  @Column(name = "nombre_cobertura", nullable = false)
  private String nombre_cobertura;

  //  RELACIONES
//  @OneToOne
//  @JoinColumn( name = "personalizar_id")
//  private Personalizar personalizar;
//
//  @OneToOne(mappedBy = "cobertura", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//  private Personalizar personalizarCobertura;
}

