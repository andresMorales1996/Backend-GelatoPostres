package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "glaseados")
public class Glaseados {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_glaseado;

  @Column(name = "nombre_glaseado", nullable = false)
  private String nombre_glaseado;

  @Column(name = "precio_glaseado", nullable = false)
  private double precio_glaseado;

//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "personalizar_id", nullable = false, unique = true)
//  private Personalizar personalizar;

  //  RELACIONES
//  @OneToOne
//  @JoinColumn( name = "personalizar_id")
//  private Personalizar personalizar;
//
//  @OneToOne( mappedBy = "glaseados")
//  private Personalizar personalizarGlaseados;
}
