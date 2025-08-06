package ec.edu.espe.ms_catalogo.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue analizerCola() {
        return QueueBuilder.durable("analizer.cola").build();
    }

    @Bean
    public Queue catalogoCola() {
        return QueueBuilder.durable("catalogo.cola").build();
    }

}
