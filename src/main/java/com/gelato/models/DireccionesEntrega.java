package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "direcciones_entrega")
public class DireccionesEntrega {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_direcciones_entrega;
  
  @Column(name = "direccion", nullable = false)
  private String direccion;
  
  @OneToOne
  @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_usuario", nullable = false)
  private Usuario usuario;
}
