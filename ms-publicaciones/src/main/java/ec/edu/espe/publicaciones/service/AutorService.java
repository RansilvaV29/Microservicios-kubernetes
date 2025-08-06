package ec.edu.espe.publicaciones.service;


import java.util.List;
import java.util.stream.Collectors;

import ec.edu.espe.publicaciones.dto.AutorDTO;
import ec.edu.espe.publicaciones.dto.RespondeDTO;
import ec.edu.espe.publicaciones.model.Autor;
import ec.edu.espe.publicaciones.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorService {
    @Autowired // Hace todo lo que se haria con el contructor y la instanciacion previa
    private AutorRepository autorRepository;

    @Autowired
    private NotificacionProducer notificacionProducer;

    public RespondeDTO crearAutor(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        autor.setEmail(autorDTO.getEmail());
        autor.setOrcid(autorDTO.getOrcid());
        autor.setNacionalidad(autorDTO.getNacionalidad());
        autor.setTelefono(autorDTO.getTelefono());
        autor.setInstitucion(autorDTO.getInstitucion());

        //Notificar el evento
        notificacionProducer.enviarNotificacion(
                "Nuevo autor registrado" + autor.getNombre() + autor.getApellido(), "Nuevo autor"
        );

        return new RespondeDTO(
                "Autor registrado correctamente",
                autorRepository.save(autor));
    }

    public RespondeDTO actualizarAutor(Long id, AutorDTO autorDTO) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        autor.setEmail(autorDTO.getEmail());
        autor.setOrcid(autorDTO.getOrcid());
        autor.setNacionalidad(autorDTO.getNacionalidad());
        autor.setTelefono(autorDTO.getTelefono());
        autor.setInstitucion(autorDTO.getInstitucion());



        return new RespondeDTO(
                "Autor actualizado correctamente",
                autorRepository.save(autor));
    }

    public List<RespondeDTO> listarAutores() {
        return autorRepository.findAll()
                .stream()
                .map(a -> new RespondeDTO(
                        "Autor " + a.getNombre(), a))

                .collect(Collectors.toList());

    }

    public RespondeDTO eliminarAutor(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        autorRepository.delete(autor);
        return new RespondeDTO(
                "Autor eliminado correctamente",
                null);
    }
}