package com.michilatte.ecomarket.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_comprador")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    private Date fechaPedido;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    private float total;

    public enum EstadoPedido {
        pendiente,
        en_proceso,
        enviado,
        entregado,
        cancelado
    }

}

