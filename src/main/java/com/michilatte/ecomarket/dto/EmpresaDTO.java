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
    private Integer mercadoDTO;
    private String paisDTO = "Chile";
    private String numIdentificacionDTO;
}

