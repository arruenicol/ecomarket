package com.michilatte.ecomarket.dto;

import com.michilatte.ecomarket.model.Vendedor;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendedorDTO {
    private Integer idVendedorDTO;
    private String nombreVendedorDTO;
    private String apellidoVendedorDTO;
    private Vendedor.TipoDoc tipoDocDTO;
    private String numIdentificadorDTO;
    private Date fechaNacimientoDTO;
    private String telefonoDTO;
    private String correoDTO;
    private String contraseniaDTO;
}
