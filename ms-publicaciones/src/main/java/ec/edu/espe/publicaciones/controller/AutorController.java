package ec.edu.espe.publicaciones.controller;


import java.util.List;

import ec.edu.espe.publicaciones.dto.AutorDTO;
import ec.edu.espe.publicaciones.dto.RespondeDTO;
import ec.edu.espe.publicaciones.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<RespondeDTO> listarAutores() {
        return autorService.listarAutores();
    }

    @PostMapping
    public RespondeDTO crearAutor(@RequestBody AutorDTO autorDTO) {
        return autorService.crearAutor(autorDTO);
    }

    @PutMapping("/{id}")
    public RespondeDTO actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        return autorService.actualizarAutor(id, autorDTO);
    }
    @DeleteMapping("/{id}")
    public RespondeDTO eliminarAutor(@PathVariable Long id) {
        return autorService.eliminarAutor(id);
    }
}