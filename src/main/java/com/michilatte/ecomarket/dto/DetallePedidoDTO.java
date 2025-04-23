package com.michilatte.ecomarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoDTO {
    private Long idDetallePedidoDTO;
    private ProductoDTO productoDTO;
    private Integer cantidadDTO;
    private Float precioUnitarioDTO;
}
