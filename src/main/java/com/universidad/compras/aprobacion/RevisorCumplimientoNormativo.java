package com.universidad.compras.aprobacion;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.universidad.compras.modelo.Solicitud;

@Component
@Order(1)
public class RevisorCumplimientoNormativo extends ManejadorAprobacion {
    public static final String NOMBRE = "Revisor de Cumplimiento Normativo";

    @Override
    protected boolean puedeResolver(Solicitud s) {
        return "INTERNACIONAL".equals(s.getCategoria());
    }

    @Override
    protected ResultadoAprobacion resolver(Solicitud s) {
        return new ResultadoAprobacion(true, NOMBRE, "Cumple la normativa de compras internacionales");
    }
}