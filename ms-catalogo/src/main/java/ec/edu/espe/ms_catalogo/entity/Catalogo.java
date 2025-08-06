//id, mensaje, fecha tipo

package ec.edu.espe.ms_catalogo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "catalogo")
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPublicacion;
    private String titulo;
    private String nombreAutor;
    private String idioma;
    private LocalDateTime fechaCreacion;

}