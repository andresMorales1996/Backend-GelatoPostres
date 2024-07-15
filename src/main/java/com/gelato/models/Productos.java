package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "productos")
public class Productos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_producto")
  private Long idProducto;

  @Column(name = "nombre_producto", nullable = false)
  private String nombreProducto;

  @Column(name = "descripcion_producto", nullable = false)
  private String descripcionProducto;

  @Column(name = "estado_producto", nullable = false)
  private Boolean estadoProducto;

  @Column(name = "imagen_producto", nullable = false)
  @Lob
  private byte[] imagenProducto;

  @Column(name = "precio_producto", nullable = false)
  private double precioProducto;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_categoria")
  private Categorias categoria;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_porcion")
  private Porciones porcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_relleno")
  private Rellenos relleno;
  
}
