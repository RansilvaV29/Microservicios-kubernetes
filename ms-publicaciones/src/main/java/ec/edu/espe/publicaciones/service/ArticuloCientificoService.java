package ec.edu.espe.publicaciones.service;


import ec.edu.espe.publicaciones.dto.ArticuloCientificoDTO;
import ec.edu.espe.publicaciones.dto.RespondeDTO;
import ec.edu.espe.publicaciones.model.ArticuloCientifico;
import ec.edu.espe.publicaciones.model.Autor;
import ec.edu.espe.publicaciones.repository.ArticuloCientificoRepository;
import ec.edu.espe.publicaciones.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloCientificoService {

    @Autowired
    private ArticuloCientificoRepository articuloCientificoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CatalogoProducer catalogoProducer;


    public RespondeDTO crearArticuloCientifico(ArticuloCientificoDTO articuloDTO) {
        Autor autor = autorRepository.findById(articuloDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + articuloDTO.getAutorId()));

        ArticuloCientifico articulo = new ArticuloCientifico();
        articulo.setTitulo(articuloDTO.getTitulo());
        articulo.setAniopublicacion(articuloDTO.getAniopublicacion());
        articulo.setResumen(articuloDTO.getResumen());
        articulo.setIdioma(articuloDTO.getIdioma());
        articulo.setDoi(articuloDTO.getDoi());
        articulo.setRevista(articuloDTO.getRevista());
        articulo.setAreaInvestigacion(articuloDTO.getAreaInvestigacion());
        articulo.setFechaPublicacion(articuloDTO.getFechaPublicacion());
        articulo.setAutor(autor);

        // Enviar notificacion a catalogo
        // Notificar a ms-catalogo
        catalogoProducer.enviarCatalogo(
                "Artículo Científico",
                articuloDTO.getTitulo(),
                autor.getNombre() + " " + autor.getApellido(),
                articuloDTO.getIdioma()
        );

        ArticuloCientifico savedArticulo = articuloCientificoRepository.save(articulo);
        return new RespondeDTO("Artículo científico registrado correctamente", savedArticulo);
    }

    public RespondeDTO actualizarArticuloCientifico(Long id, ArticuloCientificoDTO articuloDTO) {
        ArticuloCientifico articulo = articuloCientificoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo científico no encontrado con ID: " + id));

        Autor autor = autorRepository.findById(articuloDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + articuloDTO.getAutorId()));

        articulo.setTitulo(articuloDTO.getTitulo());
        articulo.setAniopublicacion(articuloDTO.getAniopublicacion());
        articulo.setResumen(articuloDTO.getResumen());
        articulo.setIdioma(articuloDTO.getIdioma());
        articulo.setDoi(articuloDTO.getDoi());
        articulo.setRevista(articuloDTO.getRevista());
        articulo.setAreaInvestigacion(articuloDTO.getAreaInvestigacion());
        articulo.setFechaPublicacion(articuloDTO.getFechaPublicacion());
        articulo.setAutor(autor);

        ArticuloCientifico updatedArticulo = articuloCientificoRepository.save(articulo);
        return new RespondeDTO("Artículo científico actualizado correctamente", updatedArticulo);
    }

    public RespondeDTO listarArticulosCientificos() {
        List<ArticuloCientificoDTO> articulos = articuloCientificoRepository.findAll()
                .stream()
                .map(a -> {
                    ArticuloCientificoDTO dto = new ArticuloCientificoDTO();
                    dto.setTitulo(a.getTitulo());
                    dto.setAniopublicacion(a.getAniopublicacion());
                    dto.setResumen(a.getResumen());
                    dto.setIdioma(a.getIdioma());
                    dto.setDoi(a.getDoi());
                    dto.setRevista(a.getRevista());
                    dto.setAreaInvestigacion(a.getAreaInvestigacion());
                    dto.setFechaPublicacion(a.getFechaPublicacion());
                    dto.setAutorId(a.getAutor() != null ? a.getAutor().getId() : null);
                    return dto;
                })
                .collect(Collectors.toList());
        return new RespondeDTO("Lista de artículos científicos recuperada", articulos);
    }

    public RespondeDTO eliminarArticuloCientifico(Long id) {
        ArticuloCientifico articulo = articuloCientificoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo científico no encontrado con ID: " + id));
        articuloCientificoRepository.delete(articulo);
        return new RespondeDTO("Artículo científico eliminado correctamente", null);
    }
}
