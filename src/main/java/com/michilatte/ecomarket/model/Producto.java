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

    private Boolean estadoStock;

    private String descripcion;

    @OneToMany(mappedBy = "producto")
    private List<CarritoItem> carritoItems;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

}
