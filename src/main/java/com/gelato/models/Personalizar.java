package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "personalizar")
public class Personalizar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_personalizar;

  @Column(name = "imagen_personalizar", nullable = false)
  @Basic(optional = false, fetch = FetchType.EAGER)
  @Lob()
  private byte[] imagen_personalizar;

  @Column(name = "adicionales_personalizar")
  private String adicionales_personalizar;

  //LLAVES FORÁNEAS
  // @OneToMany()
  // @JoinColumn(name = "personalizar_id", nullable = false)
  // private List<Relleno> rellenos;

  // @OneToOne()
  // @JoinColumn(name = "porciones_id", nullable = false)
  // private Porciones porciones;

  // @OneToOne
  // @JoinColumn(name = "ID_glaseados", nullable = false)
  // private Glaseados glaseados;

  // @OneToOne
  // @JoinColumn(name = "ID_sabor", nullable = false)
  // private Sabor sabor;

  // @OneToOne
  // @JoinColumn(name = "id_cobertura", nullable = false)
  // private Cobertura cobertura;

  // @OneToOne
  // @JoinColumn(name = "ID_toppings", nullable = false)
  // private Toppings toppings;
}
