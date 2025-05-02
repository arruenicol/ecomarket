package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Carrito;
import com.michilatte.ecomarket.model.CarritoItem;
import com.michilatte.ecomarket.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class CarritoItemTest {
        @Test
        void crearCarritoItemConExito() {
            Producto producto = new Producto();
            producto.setIdProducto(34);

            Carrito carrito = new Carrito();
            carrito.setIdCarrito(17);

            CarritoItem carritoC = new CarritoItem();
            carritoC.setIdCarritoItem(40);
            carritoC.setCantidad(50);
            carritoC.setProducto(producto);
            carritoC.setCarrito(carrito);

            assertAll(
                    () -> assertEquals(40, carritoC.getIdCarritoItem()),
                    () -> assertEquals(34, carritoC.getProducto().getIdProducto()),
                    () -> assertEquals(17, carritoC.getCarrito().getIdCarrito()),
                    () -> assertEquals(50, carritoC.getCantidad())
            );



        }
    }

