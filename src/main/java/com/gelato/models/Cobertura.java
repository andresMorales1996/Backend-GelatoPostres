package com.gelato.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "cobertura")
public class Cobertura {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id_cobertura;
  @Column( name = "nombre_cobertura", nullable = false)
  private String nombre_cobertura;

//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "personalizar_id", nullable = false, unique = true)
//  private Personalizar personalizar;

}

