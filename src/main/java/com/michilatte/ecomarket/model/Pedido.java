package com.michilatte.ecomarket.model;
import jakarta.persistence.*;



@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Se guarda como "PENDIENTE", "ENVIADO", etc.
    @Column(name = "estado")
    private EstadoPedido estado;


    public enum EstadoPedido {
        PENDIENTE,
        EN_PROCESO,
        ENVIADO,
        ENTREGADO,
        CANCELADO
    }

    // Getters y Setters
}

