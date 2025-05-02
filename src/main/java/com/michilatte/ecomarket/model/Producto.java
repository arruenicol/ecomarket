package com.michilatte.ecomarket.model;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    private Float precio;

    private Integer cantidad;

    @Schema(description = "URL de imágen del producto")
    private String imagenUrl;

    @OneToMany(mappedBy = "producto")
    private List<CarritoItem> carritoItems;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

}
