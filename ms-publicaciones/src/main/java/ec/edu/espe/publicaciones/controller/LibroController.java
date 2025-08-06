package ec.edu.espe.publicaciones.controller;

import ec.edu.espe.publicaciones.dto.LibroDTO;
import ec.edu.espe.publicaciones.dto.RespondeDTO;
import ec.edu.espe.publicaciones.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public RespondeDTO listarLibros() {
        return libroService.listarLibros();
    }

    @PostMapping
    public RespondeDTO crearLibro(@RequestBody LibroDTO libroDTO) {
        return libroService.crearLibro(libroDTO);
    }

    @PutMapping("/{id}")
    public RespondeDTO actualizarLibro(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        return libroService.actualizarLibro(id, libroDTO);
    }

    @DeleteMapping("/{id}")
    public RespondeDTO eliminarLibro(@PathVariable Long id) {
        return libroService.eliminarLibro(id);
    }
}