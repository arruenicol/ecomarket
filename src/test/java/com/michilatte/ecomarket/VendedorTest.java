package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Vendedor;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class VendedorTest {
    @Test
    void crearVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(1);
        vendedor.setNombre("Mamoune");
        vendedor.setApellido("Joseph");
        vendedor.setTipoDoc(Vendedor.TipoDoc.rut);
        vendedor.setNumIdentificador("18234517-8");
        vendedor.setFechaNacimiento(new Date(2003, 12, 31));
        vendedor.setTelefono("+56947174334");
        vendedor.setCorreo("josephmamoune@gmail.com");
        vendedor.setContrasenia("momma1712");

        assertAll(
                () -> assertEquals(1, vendedor.getIdVendedor()),
                () -> assertEquals("Mamoune", vendedor.getNombre()),
                () -> assertEquals("Joseph", vendedor.getApellido()),
                () -> assertEquals(Vendedor.TipoDoc.rut, vendedor.getTipoDoc()),
                () -> assertEquals("18234517-8", vendedor.getNumIdentificador()),
                () -> assertEquals( new Date (2003, 12, 31), vendedor.getFechaNacimiento()),
                () -> assertEquals("+56947174334", vendedor.getTelefono()),
                () -> assertEquals("josephmamoune@gmail.com", vendedor.getCorreo()),
                () -> assertEquals("momma1712", vendedor.getContrasenia())
        );

    }
}
