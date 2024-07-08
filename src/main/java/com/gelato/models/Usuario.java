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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID_usuario")
    private long ID_usuario;
    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    @Column(name = "telefono_usuario")
    private String telefono_usuario;
    @Column(name = "email_usuario")
    private String email_usuario;
    @Column(name = "contrasena_usuario")
    private String contrasena_usuario;
    @Column(name = "genero_usuario")
    private String genero_usuario;
    @Column(name = "imagen_usuario")
    private String imagen_usuario;
}
