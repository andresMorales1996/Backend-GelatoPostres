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
  @Column(name = "ID_pedido_detalle")
  private Long ID_pedido_detalle;

  @Column(name = "cantidad", nullable = false)
  private int cantidad;

  //LLAVES FORÁNEAS
//  @OneToOne
//  @JoinColumn(name = "ID_pedido", nullable = false)
//  private Pedido pedido;
//
//  @OneToOne
//  @JoinColumn(name = "ID_estado_pago", nullable = false)
//  private EstadoPago estadoPago;
//
//  @OneToOne
//  @JoinColumn(name = "ID_producto", nullable = false)
//  private Productos producto;

}
