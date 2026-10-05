package com.universidad.compras.aprobacion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.universidad.compras.modelo.Solicitud;

@Component
@Order(4)
public class DirectorFinanciero extends ManejadorAprobacion {
    public static final String NOMBRE = "Director Financiero";

    @Override
    protected boolean puedeResolver(Solicitud s) { return true; }

    @Override
    protected ResultadoAprobacion resolver(Solicitud s) {
        return new ResultadoAprobacion(true, NOMBRE, "Aprobada por el Director Financiero");
    }
}