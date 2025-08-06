package ec.edu.espe.publicaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ec.edu.espe.publicaciones.model")
public class MsPublicacionesRepasoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPublicacionesRepasoApplication.class, args);
	}

}
