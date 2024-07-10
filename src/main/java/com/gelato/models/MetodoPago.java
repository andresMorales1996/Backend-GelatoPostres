package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "metodo_pago")

public class MetodoPago {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_metodo_pago;

  @Column(name = "nombre_metodo_pago", nullable = false)
  private String nombre_metodo_pago;

}
