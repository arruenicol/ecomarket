package com.michilatte.ecomarket.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    private String nombreProducto;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    private Integer estadoStock;
    private String descripcion;


    @OneToMany(mappedBy = "producto")
    private List<CarritoItem> carritoItems;


}
