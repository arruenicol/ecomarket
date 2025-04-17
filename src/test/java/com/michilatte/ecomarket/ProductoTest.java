package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Categoria;
import com.michilatte.ecomarket.model.ECategoria;
import com.michilatte.ecomarket.model.Producto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ProductoTest {
    @Test
    void cuandoCreoUnProductoConDatosValidosDebeMantenerValoresAsignados() {
        Categoria categoriaMujer = new Categoria();
        categoriaMujer.setNombre(ECategoria.Mujer);


        Producto producto = new Producto();
        producto.setIdProducto(1);
        producto.setNombreProducto("Vestido");
        producto.setCategoria(categoriaMujer);
        producto.setEstadoStock(true);

        assertAll("Verificar las distintas propiedades del producto",
                () -> assertEquals(1, producto.getIdProducto()),
                () -> assertEquals ("Vestido", producto.getNombreProducto()),
                () -> assertEquals(true, producto.getEstadoStock()),
                () -> assertEquals("Mujer", producto.getCategoria().getNombre()));

    }
}
