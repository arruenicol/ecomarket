package com.michilatte.ecomarket.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Integer idProductoDTO;
    private String nombreProductoDTO;
    private CategoriaDTO categoriaDTO;
    private String descripcionDTO;
    private EmpresaDTO empresaDTO; // DUDA: ¿Se pueden traer solo algunas propiedades desde EmpresaDTO?
    private Float precioDTO;
    private Integer cantidadDTO;  // HACER: ¡Cambiar tipo de dato a Integer en la BD!
}
