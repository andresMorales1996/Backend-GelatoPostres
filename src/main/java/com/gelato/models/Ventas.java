package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ventas")

public class Ventas {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_venta;

  @Column(name = "fecha", nullable = false )
  private Date fecha;

  @Column(name = "total_venta", nullable = false)
  private Double total_venta;

  @OneToOne
  @JoinColumn(name = "ID_metodo_pago", nullable = false)
  private MetodoPago metodoPago;

  @OneToOne
  @JoinColumn(name = "ID_pedido_detalles", nullable = false)
  private PedidoDetalles pedidoDetalles;

  @OneToOne
  @JoinColumn(name = "ID_estado_pago", nullable = false)
  private EstadoPago estadoPago;

//  @OneToOne
//  @JoinColumn(name = "ID_direcciones_entrega", nullable = false)
//  private DireccionesEntrega direccionesEntrega;

}
