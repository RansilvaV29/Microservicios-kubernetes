package ec.edu.espe.ms_notificaciones.listener;


import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.ms_notificaciones.dto.HoraServidorDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SincronizacionRelojListener {
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "reloj.sincronizacion")
    public void sincronizacionReloj(String mensajeJson) {
        try {
            HoraServidorDto dto = objectMapper.readValue(mensajeJson, HoraServidorDto.class);
            System.out.println("Hora sincronizada recibida" + dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
