package ec.edu.espe.ms_catalogo.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.espe.ms_catalogo.dto.CatalogoDto;
import ec.edu.espe.ms_catalogo.entity.Catalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.ms_catalogo.repository.CatalogoRepository;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private NotificacionProducer notificacionProducer;

    public void guardarCatalogo(CatalogoDto catalogoDto) {
        Catalogo catalogo = new Catalogo();
        catalogo.setTipoPublicacion(catalogoDto.getTipoPublicacion());
        catalogo.setTitulo(catalogoDto.getTitulo());
        catalogo.setNombreAutor(catalogoDto.getNombreAutor());
        catalogo.setIdioma(catalogoDto.getIdioma());
        catalogo.setFechaCreacion(LocalDateTime.now());
        catalogoRepository.save(catalogo);

        notificacionProducer.enviarNotificacion(
                "Nueva publicación en catálogo: " + catalogoDto.getTitulo(),
                catalogoDto.getTipoPublicacion()
        );
    }

    public List<Catalogo> obtenerCatalogos() {
        // Lógica para obtener todas las notificaciones
        return catalogoRepository.findAll();
    }
}
