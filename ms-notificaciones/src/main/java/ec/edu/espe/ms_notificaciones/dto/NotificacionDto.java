//mensaje, tipo

package ec.edu.espe.ms_notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NotificacionDto {
    private String mensaje;

    private String tipo;

}