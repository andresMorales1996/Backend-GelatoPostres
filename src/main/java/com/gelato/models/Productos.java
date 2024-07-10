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

    @Column(name = "disponibilidad", nullable = false)
    private Boolean disponibilidad;

    @Column(name = "imagen_producto", nullable = false)
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Lob()
    private byte[] imagen_producto;

    @OneToOne
    @JoinColumn(name = "categoria_ID_categoria", nullable = false)
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "relleno_ID_relleno", nullable = false)
    private Relleno relleno;

    @OneToOne
    @JoinColumn(name = "porciones_ID_porciones", nullable = false)
    private Porciones porciones;

}
