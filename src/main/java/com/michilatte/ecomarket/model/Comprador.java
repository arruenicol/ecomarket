package com.michilatte.ecomarket.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComprador;

    private String nombre;

    private String apellido;

    @Enumerated(EnumType.STRING)
    private TipoDoc tipoDoc;

    private String numIdentificador;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;
    private String contrasenia;

    @OneToMany(mappedBy = "comprador")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "comprador")
    private List<Carrito> carritos;

    @OneToMany(mappedBy = "comprador")
    private List<Pedido> pedidos;

    public enum TipoDoc {
        rut, dni, pasaporte, cin
    }

}