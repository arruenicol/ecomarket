package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Carrito;
import com.michilatte.ecomarket.model.Comprador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoTest {
    @Test
    void crearCarritoConExito() {
        Comprador comprador = new Comprador();
        comprador.setIdComprador(1);
        Carrito carrito = new Carrito();
        carrito.setIdCarrito(12);
        carrito.setComprador(comprador);

        assertAll(
                () -> assertEquals(12, carrito.getIdCarrito()),
                () -> assertEquals(1, carrito.getComprador().getIdComprador())

        );
    }
}
