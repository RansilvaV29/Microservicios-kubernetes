package ec.edu.espe.publicaciones.config;

import ec.edu.espe.publicaciones.service.RelojProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ShedulingConfig {
    @Autowired
    private RelojProducer relojProducer;

    @Scheduled(fixedRate = 10000)
    public void reportarHora() {
        try {
            relojProducer.enviarHora();
            System.out.println("Nodo: ms-publicaciones -> enviando hora");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
