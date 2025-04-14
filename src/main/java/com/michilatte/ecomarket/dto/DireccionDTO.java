package com.michilatte.ecomarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DireccionDTO {
    private Integer idDireccion;
    private String direccion;
    private String comuna;
    private String region;
    private String codigoPostal;
}
