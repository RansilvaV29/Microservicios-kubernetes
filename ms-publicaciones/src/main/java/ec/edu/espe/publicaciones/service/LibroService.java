package ec.edu.espe.publicaciones.service;


import ec.edu.espe.publicaciones.dto.LibroDTO;
import ec.edu.espe.publicaciones.dto.RespondeDTO;
import ec.edu.espe.publicaciones.model.Autor;
import ec.edu.espe.publicaciones.model.Libro;
import ec.edu.espe.publicaciones.repository.AutorRepository;
import ec.edu.espe.publicaciones.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CatalogoProducer catalogoProducer;


    public RespondeDTO crearLibro(LibroDTO libroDTO) {
        Autor autor = autorRepository.findById(libroDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + libroDTO.getAutorId()));

        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAniopublicacion(libroDTO.getAniopublicacion());
        libro.setEditoral(libroDTO.getEditoral());
        libro.setInbm(libroDTO.getInbm());
        libro.setResumen(libroDTO.getResumen());
        libro.setIdioma(libroDTO.getIdioma());
        libro.setGenero(libroDTO.getGenero());
        libro.setNumeroPaginas(libroDTO.getNumeroPaginas());
        libro.setEdicion(libroDTO.getEdicion());
        libro.setAutor(autor);

        catalogoProducer.enviarCatalogo(
                "Libro",
                libroDTO.getTitulo(),
                autor.getNombre() + " " + autor.getApellido(),
                libroDTO.getIdioma()
        );

        return new RespondeDTO("Libro registrado correctamente", libroRepository.save(libro));
    }

    public RespondeDTO actualizarLibro(Long id, LibroDTO libroDTO) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));

        Autor autor = autorRepository.findById(libroDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + libroDTO.getAutorId()));

        libro.setTitulo(libroDTO.getTitulo());
        libro.setAniopublicacion(libroDTO.getAniopublicacion());
        libro.setEditoral(libroDTO.getEditoral());
        libro.setInbm(libroDTO.getInbm());
        libro.setResumen(libroDTO.getResumen());
        libro.setIdioma(libroDTO.getIdioma());
        libro.setGenero(libroDTO.getGenero());
        libro.setNumeroPaginas(libroDTO.getNumeroPaginas());
        libro.setEdicion(libroDTO.getEdicion());
        libro.setAutor(autor);

        return new RespondeDTO("Libro actualizado correctamente", libroRepository.save(libro));
    }

    public RespondeDTO listarLibros() {
        List<LibroDTO> libros = libroRepository.findAll()
                .stream()
                .map(l -> {
                    LibroDTO dto = new LibroDTO();
                    dto.setTitulo(l.getTitulo());
                    dto.setAniopublicacion(l.getAniopublicacion());
                    dto.setEditoral(l.getEditoral());
                    dto.setInbm(l.getInbm());
                    dto.setResumen(l.getResumen());
                    dto.setIdioma(l.getIdioma());
                    dto.setGenero(l.getGenero());
                    dto.setNumeroPaginas(l.getNumeroPaginas());
                    dto.setEdicion(l.getEdicion());
                    dto.setAutorId(l.getAutor() != null ? l.getAutor().getId() : null);
                    return dto;
                })
                .collect(Collectors.toList());
        return new RespondeDTO("Lista de libros recuperada", libros);
    }

    public RespondeDTO eliminarLibro(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
        libroRepository.delete(libro);
        return new RespondeDTO("Libro eliminado correctamente", null);
    }
}
