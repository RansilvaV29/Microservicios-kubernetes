package ec.edu.espe.ms_notificaciones.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.ms_notificaciones.dto.NotificacionDto;
import ec.edu.espe.ms_notificaciones.service.NotificacionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacionListener {
    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "notificaciones.cola")
    public void recibirNotificacion(String mensajeJson) {
        try {
            NotificacionDto dto = objectMapper.readValue(mensajeJson, NotificacionDto.class);
            notificacionService.guardarNotificacion(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
