package com.universidad.compras.aprobacion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.universidad.compras.modelo.Solicitud;

@Component
@Order(3)
public class GerenteArea extends ManejadorAprobacion {
    private static final double LIMITE = 10_000_000;
    public static final String NOMBRE = "Gerente de Área";

    @Override
    protected boolean puedeResolver(Solicitud s) { return s.getMonto() <= LIMITE; }

    @Override
    protected ResultadoAprobacion resolver(Solicitud s) {
        return new ResultadoAprobacion(true, NOMBRE, "Dentro de la autoridad del gerente");
    }
}