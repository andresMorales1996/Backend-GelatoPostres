package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Roles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_rol;

  @Column(name = "nombre_rol", nullable = false)
  private String nombre_rol;

//  RELACIONES
//  @OneToOne(mappedBy = "rol")
//  private Usuario usuario;
}

