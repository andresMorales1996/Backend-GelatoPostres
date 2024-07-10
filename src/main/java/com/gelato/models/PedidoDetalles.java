package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedido_detalles")

public class PedidoDetalles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_pedido_detalle;

  @Column(name = "cantidad", nullable = false)
  private int cantidad;



}
