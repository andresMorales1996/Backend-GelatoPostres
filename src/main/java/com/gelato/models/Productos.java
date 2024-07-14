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
  private Long ID_producto;

  @Column(name = "nombre_producto", nullable = false)
  private String nombre_producto;

  @Column(name = "descripcion_producto", nullable = false)
  private String descripcion_producto;

  @Column(name = "estado_producto", nullable = false)
  private Boolean estado_producto;

  @Column(name = "imagen_producto", nullable = false)
  @Basic(optional = false, fetch = FetchType.EAGER)
  @Lob()
  private byte[] imagen_producto;

  @Column(name = "precio_producto", nullable = false)
  private double precio_producto;


  //  RELACIONES
//    @OneToOne
//    @JoinColumn(name = "ID_categoria", nullable = false)
//    private Categoria categoria;
//
//    @OneToOne
//    @JoinColumn(name = "ID_relleno", nullable = false)
//    private Relleno relleno;
//
//    @OneToOne
//    @JoinColumn(name = "ID_porcion", nullable = false)
//    private Porciones porcion;

}
