package com.michilatte.ecomarket.dto;

import com.michilatte.ecomarket.model.Pedido;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDTO {
    private Integer idPedidoDTO;
    private CompradorDTO compradorDTO;
    private DireccionDTO direccionDTO;
    private Date fechaPedidoDTO;
    private Pedido.EstadoPedido estadoDTO;
    private Float total;
    private List<DetallePedidoDTO> detalleDTO;
}
