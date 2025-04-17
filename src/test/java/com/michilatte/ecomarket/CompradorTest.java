package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Comprador;
import com.michilatte.ecomarket.model.Direccion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CompradorTest {
    @Test
    void crearCompradorConExito() {
        Direccion direccion = new Direccion();
        direccion.setDireccion("Pasaje Michilatte 123");
        Comprador comprador = new Comprador();
        comprador.setDirecciones(Collections.singletonList(direccion));
        comprador.setNombre("Maria Jenna");
        comprador.setApellido("Cruz");
        comprador.setIdComprador(1243);
        comprador.setTipoDoc(Comprador.TipoDoc.rut);
        comprador.setNumIdentificador("12234576-5");
        comprador.setFechaNacimiento(new Date(1992, 5, 23));
        comprador.setTelefono("+56942341756");
        comprador.setCorreo("Mariadelacruz@gmail.com");
        comprador.setContrasenia("QueenJenny2342");

        assertAll(
                ()-> assertEquals("Pasaje Michilatte 123",
                        comprador.getDirecciones().get(0).getDireccion()),
                ()-> assertEquals("Maria Jenna",comprador.getNombre()),
                ()-> assertEquals("Cruz",comprador.getApellido()),
                ()-> assertEquals(1243,comprador.getIdComprador()),
                ()-> assertEquals(Comprador.TipoDoc.rut,comprador.getTipoDoc()),
                ()-> assertEquals("12234576-5",comprador.getNumIdentificador()),
                ()-> assertEquals(new Date(1992, 5, 23),comprador.getFechaNacimiento()),
                ()-> assertEquals("+56942341756",comprador.getTelefono()),
                ()-> assertEquals("Mariadelacruz@gmail.com",comprador.getCorreo()),
                ()-> assertEquals("QueenJenny2342",comprador.getContrasenia())
        );

    }
}