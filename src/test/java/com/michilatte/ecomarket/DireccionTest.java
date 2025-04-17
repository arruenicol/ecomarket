package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Comprador;
import com.michilatte.ecomarket.model.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DireccionTest {
    @Test
    void crearDireccionConExito() {
        Comprador comprador = new Comprador();
        comprador.setIdComprador(1243);
        Direccion direccion = new Direccion();
        direccion.setIdDireccion(34);
        direccion.setDireccion("Pasaje Michilatte 123");
        direccion.setComuna("Conchali");
        direccion.setRegion("Metropolitana");
        direccion.setCodigoPostal("8520000");
        direccion.setComprador(comprador);

        assertAll(
                ()-> assertEquals(1243,direccion.getComprador().getIdComprador()),
                ()-> assertEquals(34,direccion.getIdDireccion()),
                ()-> assertEquals("Pasaje Michilatte 123", direccion.getDireccion()),
                ()-> assertEquals("Conchali",direccion.getComuna()),
                ()-> assertEquals("Metropolitana", direccion.getRegion()),
                ()-> assertEquals("8520000", direccion.getCodigoPostal()));

    }
}