package ec.edu.espe.publicaciones.repository;

import ec.edu.espe.publicaciones.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
