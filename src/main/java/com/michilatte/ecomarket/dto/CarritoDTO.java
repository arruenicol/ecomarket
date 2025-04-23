package com.michilatte.ecomarket.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarritoDTO {
    private Integer idCarritoDTO;
    private CompradorDTO compradorDTO;
    private List<CarritoItemDTO> itemsDTO;
}