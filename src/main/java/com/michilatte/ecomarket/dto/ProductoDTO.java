package com.michilatte.ecomarket.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Integer idProductoDTO;
    @NotBlank
    private String nombreProductoDTO;
    private CategoriaDTO categoriaDTO;
    private String descripcionDTO;
    @NotNull
    private EmpresaDTO empresaDTO;
    @Positive
    private Float precioDTO;
    @PositiveOrZero
    private Integer cantidadDTO;
    private String imagen;
}
