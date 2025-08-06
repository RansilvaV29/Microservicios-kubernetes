package ec.edu.espe.ms_catalogo.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ec.edu.espe.ms_catalogo.dto.NotificacionDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacionProducer {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarNotificacion(String mensaje, String tipo) {
        try {
            NotificacionDto dto = new NotificacionDto(mensaje, tipo);
            String json = objectMapper.writeValueAsString(dto);
            template.convertAndSend("notificaciones.cola", json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}