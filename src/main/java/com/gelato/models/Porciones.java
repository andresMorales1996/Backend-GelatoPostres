package com.gelato.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "porciones")
public class Porciones {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_porcion;

  @Column(name = "nombre_porcion", nullable = false)
  private String nombre_porcion;

  @Column(name = "precio_porcion", nullable = false)
  private double precio_porcion;

  //  RELACIONES
  @OneToOne(mappedBy = "porciones", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonBackReference
  private Productos productos;


//    @OneToMany( mappedBy = "porciones" )
//    private List<Personalizar> personalizar;
}
