package com.gelato.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@Entity
@Table(name = "glaseados")
public class Glaseados {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id_glaseados;
  @Column( name = "nombre_glaseado", nullable = false)
  private String nombre_glaseado;
  @Column( name = "precio_glaseados", nullable = false)
  private double precio_glaseados;

  @OneToOne
  @JoinColumn( name = "personalizar_id")
  private Personalizar personalizar;
}
