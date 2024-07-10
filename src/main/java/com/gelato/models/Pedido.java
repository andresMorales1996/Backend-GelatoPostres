package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedidos")

public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_pedido;
  
  @Column(name = "fecha_pedido", nullable = false)
  private Date fecha_pedido;
  
  @Column(name = "total_pedido", nullable = false)
  private int total_pedido;
  
  @ManyToOne
  @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_usuario", nullable = false)
  private Usuario usuario;
}
