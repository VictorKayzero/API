package com.library.demo.controllers;

import com.library.demo.jdbc.Libro;
import com.library.demo.jdbc.LibroJdbcRepository;
import com.library.demo.jdbc.LoginJdbcRepository;
import com.library.demo.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@Tag(name ="LibroController")
public class LibroController {

    @Autowired
    private LibroJdbcRepository libroJdbcRepository;

    @GetMapping
    @CrossOrigin(origins= "http://localhost:3000")
    @Operation(summary = "Trae todos los libros existentes con titulo y autor")
    public List<Libro> getAllLibros() {
        return libroJdbcRepository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins= "http://localhost:3000")
    @Operation(summary = "Trae información de libros existente buscado por id")
    public Libro getLibroById(@PathVariable Long id) {
        return libroJdbcRepository.findById(id);
    }

    @PostMapping
    @CrossOrigin(origins= "http://localhost:3000")
    @Operation(summary = "Inserta información de libro")
    public ResponseEntity<String> insertLibro(@RequestBody Libro libro) {
        // Validar que ambos campos estén seteados
        if (libro.getTitulo() == null || libro.getTitulo().isEmpty()
                || libro.getAutor() == null || libro.getAutor().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Los campos 'titulo' y 'autor' son obligatorios");
        }

        // Insertar el libro utilizando el repositorio JDBC
        libroJdbcRepository.insert(libro.getTitulo(), libro.getAutor());

        return ResponseEntity.status(HttpStatus.CREATED).body("Libro insertado correctamente");
    }
    
    @PutMapping("/{id}")
    @CrossOrigin(origins= "http://localhost:3000")
    @Operation(summary = "Actualiza información de libro existente")
    public void updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        libroJdbcRepository.update(id, libro.getTitulo(), libro.getAutor());
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins= "http://localhost:3000")
    @Operation(summary = "Borra libro existente")
    public void deleteLibro(@PathVariable Long id) {
        libroJdbcRepository.delete(id);
    }
    

    @Autowired
    private BookService bookService;
    
    @GetMapping("/random")
    @CrossOrigin(origins= "http://localhost:3000")
    @Operation(summary = "Trae un autor y libro al azar desde API externa")
    public ResponseEntity<Object> getRandomBook() {
    	
        try {

            Object response = bookService.getRandomBook();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el libro aleatorio");
        }
    }
}