package ec.edu.espe.publicaciones.controller;


import ec.edu.espe.publicaciones.dto.ArticuloCientificoDTO;
import ec.edu.espe.publicaciones.dto.RespondeDTO;
import ec.edu.espe.publicaciones.service.ArticuloCientificoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articulos-cientificos")
public class ArticuloCientificoController {

    @Autowired
    private ArticuloCientificoService articuloCientificoService;

    @GetMapping
    public RespondeDTO listarArticulosCientificos() {
        return articuloCientificoService.listarArticulosCientificos();
    }

    @PostMapping
    public RespondeDTO crearArticuloCientifico(@Valid @RequestBody ArticuloCientificoDTO articuloDTO) {
        return articuloCientificoService.crearArticuloCientifico(articuloDTO);
    }

    @PutMapping("/{id}")
    public RespondeDTO actualizarArticuloCientifico(@PathVariable Long id, @Valid @RequestBody ArticuloCientificoDTO articuloDTO) {
        return articuloCientificoService.actualizarArticuloCientifico(id, articuloDTO);
    }

    @DeleteMapping("/{id}")
    public RespondeDTO eliminarArticuloCientifico(@PathVariable Long id) {
        return articuloCientificoService.eliminarArticuloCientifico(id);
    }
}