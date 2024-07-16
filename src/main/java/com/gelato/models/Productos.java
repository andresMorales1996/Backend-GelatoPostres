package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "productos")
public class Productos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_producto")
  private Long ID_producto;

  @Column(name = "nombre_producto", nullable = false)
  private String nombre_producto;

  @Column(name = "descripcion_producto", nullable = false)
  private String descripcion_producto;

  @Column(name = "estado_producto", nullable = false)
  private Boolean estado_producto;

  @Lob
  @Column(name = "imagen_producto", nullable = false, length = 100000)
  private byte[] imagen_producto;

  @Column(name = "precio_producto", nullable = false)
  private double precio_producto;

  //LLAVES FORÁNEAS
  @ManyToOne
  @JoinColumn(name = "ID_categoria")
  private Categorias categoria;

  @ManyToOne
  @JoinColumn(name = "ID_porcion")
  private Porciones porcion;

  @ManyToOne
  @JoinColumn(name = "ID_relleno")
  private Rellenos relleno;


}
