package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_usuario;
  
  @Column(name = "nombre_usuario", nullable = false)
  private String nombre_usuario;
  
  @Column(name = "telefono_usuario", nullable = false)
  private String telefono_usuario;
  
  @Column(name = "email_usuario", nullable = false, unique = true)
  private String email_usuario;
  
  @Column(name = "contrasena_usuario", nullable = false)
  private String contrasena_usuario;
  
  @Column(name = "genero_usuario", nullable = false)
  private String genero_usuario;
  
  @Column(name = "imagen_usuario")
  private byte[] imagen_usuario;
  
  /*@OneToOne
  @JoinColumn(name = "ID_rol", referencedColumnName = "ID_rol")
  private Rol rol;
  
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Pedido> pedidos;

  @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  private DireccionesEntrega direccionesEntrega;*/
}
