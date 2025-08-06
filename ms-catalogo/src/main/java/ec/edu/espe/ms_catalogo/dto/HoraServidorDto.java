package ec.edu.espe.ms_catalogo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class HoraServidorDto {
    private long horaServidor;
    private Map<String, Long> diferencias;
}
