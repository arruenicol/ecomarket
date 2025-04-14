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
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;
    private String direccion;
    private String comuna;
    private String region;
    private String codigoPostal;

    @ManyToOne
    @JoinColumn(name = "id_comprador")
    private Comprador comprador;

    @OneToMany(mappedBy = "direccion")
    private List<Pedido> pedidos;

}
