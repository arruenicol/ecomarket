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
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "mercado")
    private Categoria mercado;

    private String pais;
    private String numIdentificacion;

    @OneToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    @OneToMany(mappedBy = "empresa")
    private List<Producto> productos;


}
