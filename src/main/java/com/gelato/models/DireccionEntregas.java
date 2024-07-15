package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "direccion_entregas")
public class DireccionEntregas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_direccion_entrega")
  private Long ID_direccion_entrega;

  @Column(name = "direccion", nullable = false)
  private String direccion;

  //LLAVES FORÁNEAS
//  @OneToOne
//  @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_usuario", nullable = false)
//  private Usuario usuario;
}
