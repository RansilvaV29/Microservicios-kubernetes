package ec.edu.espe.publicaciones.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    private String titulo;
    private int aniopublicacion;
    private String editoral;
    private String inbm;
    private String resumen;
    private String idioma;
    private String genero;
    private int numeroPaginas;
    private String edicion;
    private Long autorId;

//
//    // Getters y setters
//    public String getTitulo() { return titulo; }
//    public void setTitulo(String titulo) { this.titulo = titulo; }
//    public int getAniopublicacion() { return aniopublicacion; }
//    public void setAniopublicacion(int aniopublicacion) { this.aniopublicacion = aniopublicacion; }
//    public String getEditoral() { return editoral; }
//    public void setEditoral(String editoral) { this.editoral = editoral; }
//    public String getInbm() { return inbm; }
//    public void setInbm(String inbm) { this.inbm = inbm; }
//    public String getResumen() { return resumen; }
//    public void setResumen(String resumen) { this.resumen = resumen; }
//    public String getIdioma() { return idioma; }
//    public void setIdioma(String idioma) { this.idioma = idioma; }
//    public String getGenero() { return genero; }
//    public void setGenero(String genero) { this.genero = genero; }
//    public int getNumeroPaginas() { return numeroPaginas; }
//    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }
//    public String getEdicion() { return edicion; }
//    public void setEdicion(String edicion) { this.edicion = edicion; }
//    public Long getAutorId() { return autorId; }
//    public void setAutorId(Long autorId) { this.autorId = autorId; }
}