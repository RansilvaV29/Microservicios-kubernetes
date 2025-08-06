package ec.edu.espe.ms_notificaciones.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.espe.ms_notificaciones.entity.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.ms_notificaciones.dto.NotificacionDto;
import ec.edu.espe.ms_notificaciones.repository.NotificacionRepository;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public void guardarNotificacion(NotificacionDto notificacionDto) {
        // Lógica para guardar la notificación utilizando el repositorio
        Notificacion notification = new Notificacion();
        notification.setMensaje(notificacionDto.getMensaje());
        notification.setTipo(notificacionDto.getTipo());
        notification.setFecha(LocalDateTime.now());
        notificacionRepository.save(notification);
    }

    public List<Notificacion> obtenerNotificaciones() {
        // Lógica para obtener todas las notificaciones
        return notificacionRepository.findAll();
    }
}
