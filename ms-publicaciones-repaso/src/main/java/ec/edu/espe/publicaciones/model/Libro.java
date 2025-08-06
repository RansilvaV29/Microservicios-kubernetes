package ec.edu.espe.publicaciones.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "libros")
@Getter // generar getters automáticamente
@Setter // generar setters automáticamente
public class Libro extends Publicacion {

    private String genero;
    private int numeroPaginas;
    private String edicion;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

}
