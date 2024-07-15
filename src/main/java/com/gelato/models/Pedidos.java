package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedidos")
public class Pedidos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_pedido")
  private Long ID_pedido;

  @Column(name = "fecha_pedido", nullable = false)
  private Date fecha_pedido;

  @Column(name = "fecha_entrega", nullable = false)
  private Date fecha_entrega;

  @Column(name = "total_pedido", nullable = false)
  private int total_pedido;

  //LLAVES FORÁNEAS
//  @ManyToOne
//  @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_usuario", nullable = false)
//  private Usuario usuario;
}
