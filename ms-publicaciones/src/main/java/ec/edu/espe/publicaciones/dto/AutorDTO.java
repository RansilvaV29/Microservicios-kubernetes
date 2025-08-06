package ec.edu.espe.publicaciones.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String orcid;
    private String nacionalidad;
    private String telefono;
    private String institucion;

//    // Getters y setters
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getOrcid() {
//        return orcid;
//    }
//
//    public void setOrcid(String orcid) {
//        this.orcid = orcid;
//    }
//
//    public String getNacionalidad() {
//        return nacionalidad;
//    }
//
//    public void setNacionalidad(String nacionalidad) {
//        this.nacionalidad = nacionalidad;
//    }
//
//    public String getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(String telefono) {
//        this.telefono = telefono;
//    }
//
//    public String getInstitucion() {
//        return institucion;
//    }
//
//    public void setInstitucion(String institucion) {
//        this.institucion = institucion;
//    }
}