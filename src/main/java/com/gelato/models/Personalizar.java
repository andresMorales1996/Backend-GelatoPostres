package com.gelato.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "personalizar")
public class Personalizar {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "imagen_personalizar", nullable = false)
  @Basic(optional = false, fetch = FetchType.EAGER)
  @Lob()
  private byte[] imagen_personalizar;
  @Column( name = "adicionales_personalizar")
  private String adicionales_personalizar;

  //LLaves foraneas

//  @OneToMany( mappedBy = "personalizar")
//  private List<Relleno> relleno = new ArrayList<>();
//
//  @OneToMany( mappedBy = "personalizar")
//  private List<Porciones> porciones = new ArrayList<>();

  @OneToOne( mappedBy = "personalizar")
  private Glaseados glaseados;

  @OneToOne( mappedBy = "personalizar")
  private Glaseados sabor;

  @OneToOne( mappedBy = "personalizar")
  private Glaseados cobertura;

  @OneToOne( mappedBy = "personalizar")
  private Glaseados toppings;






}