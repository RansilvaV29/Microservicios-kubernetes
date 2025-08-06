package ec.edu.espe.sincronizacion.services;

import ec.edu.espe.sincronizacion.dto.HoraClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SincronizacionService {
    @Autowired
    RelojProducer relojProducer;

    private final Map<String, Long> tiemposClientes = new ConcurrentHashMap<>();
    private static int INTERVALO_SEGUNDOS = 10;

    public void registrarTiempo(HoraClienteDto horaClienteDto) {
        tiemposClientes.put(horaClienteDto.getNombreNodo(), horaClienteDto.getHoraEnviada());
    }

    public void sincronizarRelojes() {
        if (tiemposClientes.size() >= 1) {
            System.out.println("tiemposClientes[] = " + tiemposClientes);

            long ahora = Instant.now().toEpochMilli();

            long promedio = (ahora + tiemposClientes.values().stream().mapToLong(Long::longValue).sum()) / (tiemposClientes.size() + 1);

            enviarAjustesRelojes(promedio);
        }
    }

    public void enviarAjustesRelojes(Long horaServidor) {
        System.out.println("Ajustando relojes a la hora: " + horaServidor);
        Map<String, Long> diferencias = new ConcurrentHashMap<>();
        for (Map.Entry<String, Long> entry : tiemposClientes.entrySet()) {
            System.out.println("Hora nodo" + entry.getValue());
            diferencias.put(entry.getKey(), horaServidor - entry.getValue());
        }
        System.out.println("Diferencias: " + diferencias);
        relojProducer.enviarHoraSincronizada(horaServidor, diferencias);
        tiemposClientes.clear();

    }
}
