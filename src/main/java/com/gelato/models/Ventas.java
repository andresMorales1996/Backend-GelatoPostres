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

  /* Espacio para las foreign keys */

}
