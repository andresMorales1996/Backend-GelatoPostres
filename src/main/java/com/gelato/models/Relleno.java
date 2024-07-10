package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "relleno")
public class Relleno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_relleno;

    @Column(name = "nombre_relleno", nullable = false)
    private String nombre_relleno;

    @OneToOne(mappedBy = "relleno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Productos productos;
}
