package ec.edu.espe.publicaciones.repository;

import ec.edu.espe.publicaciones.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
