package ec.edu.espe.publicaciones.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "publicaciones")
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int aniopublicacion;
    private String editoral;
    private String inbm;
    private String resumen;
    private String idioma;


}
