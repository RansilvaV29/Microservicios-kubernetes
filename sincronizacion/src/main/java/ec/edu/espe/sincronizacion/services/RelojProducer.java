package ec.edu.espe.sincronizacion.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.sincronizacion.dto.HoraServidorDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RelojProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarHoraSincronizada(long horaSincronizada, Map<String, Long> diferencias) {
        try {
            HoraServidorDto horaServidorDto = new HoraServidorDto(horaSincronizada, diferencias);
            String json = objectMapper.writeValueAsString(horaServidorDto);
            amqpTemplate.convertAndSend("reloj.sincronizacion", json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
