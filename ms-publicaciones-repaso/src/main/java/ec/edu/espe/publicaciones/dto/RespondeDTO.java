package ec.edu.espe.publicaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespondeDTO {
    private String message;
    private Object data;
}
