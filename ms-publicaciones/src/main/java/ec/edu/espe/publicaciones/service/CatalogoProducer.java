package ec.edu.espe.publicaciones.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.publicaciones.dto.CatalogoDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoProducer {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarCatalogo(String tipoPublicacion, String titulo, String nombreAutor, String idioma) {
        try {
            CatalogoDto dto = new CatalogoDto(tipoPublicacion, titulo, nombreAutor, idioma);
            String json = objectMapper.writeValueAsString(dto);
            template.convertAndSend("catalogo.cola", json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}