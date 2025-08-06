package ec.edu.espe.ms_catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDto {
    private String tipoPublicacion; // "Libro" o "Artículo Científico"
    private String titulo;
    private String nombreAutor;
    private String idioma;
}