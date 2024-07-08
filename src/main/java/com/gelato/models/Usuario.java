package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")

public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long ID_usuario;
  
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
  private String imagen_usuario;
  
  @OneToOne
  @MapsId("ID_rol")
  @JoinColumn(name = "ID_rol")
  private Rol rol;
  
}
