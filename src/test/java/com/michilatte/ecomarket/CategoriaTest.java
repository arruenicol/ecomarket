package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Categoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {
    @Test
    void crearCategoriaConExito() {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(3);
        categoria.setNombre("Mujer");
        categoria.setDescripcion("Accesorios");

        assertAll (
                () -> assertEquals(3, categoria.getIdCategoria()),
                () -> assertEquals("Mujer", categoria.getNombre()),
                () -> assertEquals("Accesorios", categoria.getDescripcion())
        );
    }
}
