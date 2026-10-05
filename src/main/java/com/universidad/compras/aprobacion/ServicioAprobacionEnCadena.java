package com.universidad.compras.aprobacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.universidad.compras.modelo.Solicitud;

@Service
public class ServicioAprobacionEnCadena implements ServicioAprobacion {
    private final ManejadorAprobacion primero;

    // Spring inyecta los manejadores ya ordenados por @Order
    public ServicioAprobacionEnCadena(List<ManejadorAprobacion> manejadores) {
        if (manejadores.isEmpty()) {
            throw new IllegalArgumentException("Se requiere al menos un nivel de aprobación");
        }
        for (int i = 0; i < manejadores.size() - 1; i++) {
            manejadores.get(i).setSiguiente(manejadores.get(i + 1));
        }
        this.primero = manejadores.get(0);
    }

    @Override
    public ResultadoAprobacion evaluar(Solicitud solicitud) {
        ResultadoAprobacion r = primero.manejar(solicitud);
        solicitud.setNivelResolutor(r.getNivelResolutor());
        solicitud.setEstado(r.isAprobada() ? "APROBADA" : "RECHAZADA");
        return r;
    }
}