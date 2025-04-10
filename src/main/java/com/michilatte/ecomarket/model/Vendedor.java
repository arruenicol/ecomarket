package com.michilatte.ecomarket.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVendedor;

    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private TipoDoc tipoDoc;

    private String numIdentificador;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;
    private String contrasenia;

    public enum TipoDoc {
        rut, dni, pasaporte, cin
    }

}