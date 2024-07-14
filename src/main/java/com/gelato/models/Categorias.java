package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_categoria;

    @Column(name = "nombre_categoria", nullable = false)
    private String nombre_categoria;

  //  RELACIONES
//    @OneToOne(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private Productos productos;
}
