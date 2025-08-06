package ec.edu.espe.ms_catalogo.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.ms_catalogo.dto.CatalogoDto;
import ec.edu.espe.ms_catalogo.dto.NotificacionDto;
import ec.edu.espe.ms_catalogo.service.CatalogoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogoListener {
    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "catalogo.cola")
    public void recibirNotificacion(String mensajeJson) {
        try {
            CatalogoDto dto = objectMapper.readValue(mensajeJson, CatalogoDto.class);
            catalogoService.guardarCatalogo(dto); //Hacer la alerta segun el eventDto
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
