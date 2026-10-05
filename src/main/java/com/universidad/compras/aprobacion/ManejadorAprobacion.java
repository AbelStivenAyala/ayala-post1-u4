package com.universidad.compras.aprobacion;

import com.universidad.compras.modelo.Solicitud;

public abstract class ManejadorAprobacion {
    private ManejadorAprobacion siguiente;

    public void setSiguiente(ManejadorAprobacion siguiente) {
        this.siguiente = siguiente;
    }

    public final ResultadoAprobacion manejar(Solicitud solicitud) {
        if (puedeResolver(solicitud)) {
            return resolver(solicitud);
        }
        if (siguiente == null) {
            return new ResultadoAprobacion(false, "Sin resolutor",
                    "Ningún nivel tiene autoridad para esta solicitud");
        }
        return siguiente.manejar(solicitud);
    }

    protected abstract boolean puedeResolver(Solicitud solicitud);
    protected abstract ResultadoAprobacion resolver(Solicitud solicitud);
}