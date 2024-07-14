package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "porciones")
public class Porciones {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_porciones;

  @Column(name = "porcion", nullable = false)
  private int porcion;

  @Column(name = "precio_porciones", nullable = false)
  private int precio_porciones;

<<<<<<< HEAD
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "personalizar_id", nullable = false, unique = true)
//    private Personalizar personalizar;
=======
  //  RELACIONES
//    @OneToOne(mappedBy = "porciones", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private Productos productos;
//
//    @OneToOne
//    @JoinColumn(name = "porciones_ID_porciones", nullable = false)
//    private Porciones porciones;
//
//    @OneToMany( mappedBy = "porciones" )
//    private List<Personalizar> personalizar;
>>>>>>> 5b7b1f1dec0d124a5c7918b93ef609f9483bf004
}
