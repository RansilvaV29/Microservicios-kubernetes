package ec.edu.espe.publicaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "articulos_cientificos")
@Getter
@Setter
public class ArticuloCientifico extends Publicacion {

    @Column(nullable = false, unique = true, length = 20)
    private String doi;
    private String revista;
    private String areaInvestigacion;
    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

}

