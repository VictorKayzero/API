package com.library.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para insertar un nuevo libro
    public void insert(String titulo, String autor) {
        String sql = "INSERT INTO libros (titulo, autor) VALUES (?, ?)";
        jdbcTemplate.update(sql, titulo, autor);
    }

    // Método para actualizar un libro por su ID
    public void update(Long id, String titulo, String autor) {
        String sql = "UPDATE libros SET titulo = ?, autor = ? WHERE id_libro = ?";
        jdbcTemplate.update(sql, titulo, autor, id);
    }

    // Método para eliminar un libro por su ID
    public void delete(Long id) {
        String sql = "DELETE FROM libros WHERE id_libro = ?";
        jdbcTemplate.update(sql, id);
    }

    // Método para obtener todos los libros
    public List<Libro> findAll() {
        String sql = "SELECT id_libro, titulo, autor FROM libros";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Libro(rs.getLong("id_libro"), rs.getString("titulo"), rs.getString("autor")));
    }

    // Método para buscar un libro por su ID
    public Libro findById(Long id) {
        String sql = "SELECT id_libro, titulo, autor FROM libros WHERE id_libro = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Libro(rs.getLong("id_libro"), rs.getString("titulo"), rs.getString("autor")));
    }
}
