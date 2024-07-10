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

  @OneToOne
  @JoinColumn( name = "personalizar_id")
  private Personalizar personalizar;

  @OneToOne(mappedBy = "cobertura", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private Personalizar personalizarCobertura;
}

