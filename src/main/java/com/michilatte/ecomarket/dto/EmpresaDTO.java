package com.michilatte.ecomarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaDTO {
    private Integer idEmpresa;
    private String nombreDTO;
    private CategoriaDTO mercadoDTO;
    private String paisDTO;
    private String numIdentificacionDTO;
    private VendedorDTO vendedorDTO;
}

