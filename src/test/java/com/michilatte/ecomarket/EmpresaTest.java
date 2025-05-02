package com.michilatte.ecomarket;

import com.michilatte.ecomarket.model.Categoria;
import com.michilatte.ecomarket.model.Empresa;
import com.michilatte.ecomarket.model.Vendedor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {
    @Test
    void crearEmpresa() {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(1);

        Categoria mercado = new Categoria();
        mercado.setIdCategoria(1);

        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(3);
        empresa.setNombre("Michilatte");
        empresa.setMercado(mercado);
        empresa.setPais("Chile");
        empresa.setNumIdentificacion("777653454-K");
        empresa.setVendedor(vendedor);

        assertAll(
                () -> assertEquals(1, empresa.getVendedor().getIdVendedor()),
                () -> assertEquals(3, empresa.getIdEmpresa()),
                () -> assertEquals("Michilatte", empresa.getNombre()),
                () -> assertEquals(1, empresa.getMercado().getIdCategoria()),
                () -> assertEquals("Chile", empresa.getPais()),
                () -> assertEquals("777653454-K", empresa.getNumIdentificacion())
        );
    }
}
