package com.gelato.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "sabor")
public class Sabor {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id_sabor;
  @Column( name = "nombre_sabor", nullable = false)
  private String nombre_sabor;
  @Column( name = "descripcion_sabor", nullable = false)
  private String descripcion_sabor;

//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "personalizar_id", nullable = false, unique = true)
//  private Personalizar personalizar;
}

