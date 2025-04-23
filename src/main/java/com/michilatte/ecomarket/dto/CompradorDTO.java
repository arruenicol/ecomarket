package com.michilatte.ecomarket.dto;

import com.michilatte.ecomarket.model.Comprador.TipoDoc;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompradorDTO {
    private Integer idCompradorDTO;
    private String nombreCompradorDTO;
    private String apellidoCompradorDTO;
    private TipoDoc tipoDocDTO;
    private String numIdentificadorDTO;
    private Date fechaNacimientoCompradorDTO;
    private String telefonoCompradorDTO;
    private String correoDTO;
    private String contraseniaDTO;
    private List<DireccionDTO> direccionesDTO;
}

