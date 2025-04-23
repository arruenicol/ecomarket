package com.michilatte.ecomarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarritoItemDTO {
    private Integer idCarritoItemDTO;
    private Integer cantidadDTO;
    private ProductoDTO productoDTO;
}
