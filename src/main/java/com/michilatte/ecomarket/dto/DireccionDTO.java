package com.michilatte.ecomarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DireccionDTO {
    private Integer idDireccionDTO;
    private String direccionDTO;
    private String comunaDTO;
    private String regionDTO;
    private String codigoPostalDTO;
}
