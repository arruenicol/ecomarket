package com.michilatte.ecomarket.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    private String nombre;
    private Integer mercado;
    private String país = "Chile";
    private String numIdentificacion;

    @ManyToOne
    private Vendedor vendedor;

}
