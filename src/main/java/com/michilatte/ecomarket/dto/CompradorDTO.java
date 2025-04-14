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
    private Integer idComprador;
    private String nombreComprador;
    private String apellidoComprador;
    private TipoDoc tipoDoc;
    private String numIdentificador;
    private Date fechaNacimientoComprador;
    private String telefonoComprador;
    private String correo;
    private String contrasenia;
    private List<DireccionDTO> direcciones;
}

