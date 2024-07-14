package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "direcciones_entrega")
public class DireccionEntregas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_direcciones_entrega;

  @Column(name = "direccion", nullable = false)
  private String direccion;

  //  RELACIONES
//  @OneToOne
//  @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_usuario", nullable = false)
//  private Usuario usuario;
}
