package ec.edu.espe.ms_notificaciones.repository;

import ec.edu.espe.ms_notificaciones.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {


}
