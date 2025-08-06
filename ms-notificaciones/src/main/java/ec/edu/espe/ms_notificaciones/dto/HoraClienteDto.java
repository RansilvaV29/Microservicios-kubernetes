package ec.edu.espe.ms_notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoraClienteDto {
    private String nombreNodo;
    private long horaEnviada;
}
