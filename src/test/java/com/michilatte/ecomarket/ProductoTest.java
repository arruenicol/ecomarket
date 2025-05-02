package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Categoria;
import com.michilatte.ecomarket.model.Producto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ProductoTest {
    @Test
    void cuandoCreoUnProductoConDatosValidosDebeMantenerValoresAsignados() {
        Categoria categoriaRopa = new Categoria();
        categoriaRopa.setNombre("ropa");


        Producto producto = new Producto();
        producto.setIdProducto(1);
        producto.setNombreProducto("Vestido");
        producto.setCategoria(categoriaRopa);

        assertAll("Verificar las distintas propiedades del producto",
                () -> assertEquals(1, producto.getIdProducto()),
                () -> assertEquals ("Vestido", producto.getNombreProducto()),
                () -> assertEquals("ropa", producto.getCategoria().getNombre()));

    }
}
