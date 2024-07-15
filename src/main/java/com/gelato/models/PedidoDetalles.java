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
  private Long ID_pedido_detalle;

  @Column(name = "cantidad", nullable = false)
  private int cantidad;

  //  RELACIONES
//  @OneToOne(mappedBy = "pedido_detalles", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//  private PedidoDetalles pedido_detalles;
//
//  @OneToOne
//  @JoinColumn(name = "ID_estado_pago", nullable = false)
//  private EstadoPago estadoPago;
//
//  @OneToOne
//  @JoinColumn(name = "ID_producto", nullable = false)
//  private Productos producto;

}
