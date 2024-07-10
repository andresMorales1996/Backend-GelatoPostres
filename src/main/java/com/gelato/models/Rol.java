package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rol")
public class Rol {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_rol;
  
  @Column(name = "rol", nullable = false)
  private String rol;
  
/*  @OneToOne(mappedBy = "rol")
  private Usuario usuario;*/
}

