package com.michilatte.ecomarket;


import com.michilatte.ecomarket.model.Comprador;
import com.michilatte.ecomarket.model.Direccion;
import com.michilatte.ecomarket.model.Comprador.TipoDoc;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CompradorTest {

    @Test
    void cuandoCreoUnCompradorConDireccionDebeMantenerLosValoresCorrectos() {
        // Arrange
        Date fechaNacimiento = new Date();

        Comprador comprador = Comprador.builder()
                .idComprador(1)
                .nombre("Laura")
                .apellido("Fernández")
                .tipoDoc(TipoDoc.rut)
                .numIdentificador("12345678-9")
                .fechaNacimiento(fechaNacimiento)
                .telefono("+56912345678")
                .correo("laura@example.com")
                .contrasenia("secreta123")
                .build();

        Direccion direccion = Direccion.builder()
                .idDireccion(10)
                .direccion("Av. Providencia 1234")
                .comuna("Providencia")
                .region("Metropolitana")
                .codigoPostal("7500000")
                .comprador(comprador)
                .build();

        comprador.setDirecciones(Collections.singletonList(direccion));

        // Assert
        assertAll("Verificar propiedades del comprador y su dirección",
                () -> assertEquals("Laura", comprador.getNombre()),
                () -> assertEquals("Fernández", comprador.getApellido()),
                () -> assertEquals(TipoDoc.rut, comprador.getTipoDoc()),
                () -> assertEquals(1, comprador.getIdComprador()),
                () -> assertEquals("12345678-9", comprador.getNumIdentificador()),
                () -> assertEquals("laura@example.com", comprador.getCorreo()),
                () -> assertEquals(1, comprador.getDirecciones().size()),
                () -> assertEquals("Av. Providencia 1234", comprador.getDirecciones().get(0).getDireccion()),
                () -> assertEquals(comprador, comprador.getDirecciones().get(0).getComprador())
        );
    }
}
