package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedido_estados")
public class PedidoEstados {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_pedido_estado")
  private Long ID_pedido_estado;

  @Column(name = "nombre_pedido_estado", nullable = false)
  private String nombre_pedido_estado;

}
