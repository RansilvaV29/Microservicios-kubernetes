package ec.edu.espe.publicaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class ArticuloCientificoDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotNull(message = "El año de publicación es obligatorio")
    private Integer aniopublicacion;

    private String resumen;

    @NotBlank(message = "El idioma es obligatorio")
    private String idioma;

    @NotBlank(message = "El DOI es obligatorio")
    @Size(max = 20, message = "El DOI no puede exceder 20 caracteres")
    private String doi;

    private String revista;

    private String areaInvestigacion;

    @NotNull(message = "La fecha de publicación es obligatoria")
    private Date fechaPublicacion;

    @NotNull(message = "El ID del autor es obligatorio")
    private Long autorId;
}
