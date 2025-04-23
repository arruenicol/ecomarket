package com.michilatte.ecomarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Integer idProducto;

    private String nombreProducto;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    private String descripcion;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    private Float precio;

    private Integer cantidad; //cambiar tipo a integer

    @OneToMany(mappedBy = "producto")
    private List<CarritoItem> carritoItems;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

}
