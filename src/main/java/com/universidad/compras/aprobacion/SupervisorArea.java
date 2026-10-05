package com.universidad.compras.aprobacion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.universidad.compras.modelo.Solicitud;

@Component
@Order(2)
public class SupervisorArea extends ManejadorAprobacion {
    private static final double LIMITE = 2_000_000;
    public static final String NOMBRE = "Supervisor de Área";

    @Override
    protected boolean puedeResolver(Solicitud s) { return s.getMonto() <= LIMITE; }

    @Override
    protected ResultadoAprobacion resolver(Solicitud s) {
        return new ResultadoAprobacion(true, NOMBRE, "Dentro de la autoridad del supervisor");
    }
}