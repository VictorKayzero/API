package com.library.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para verificar usuario existente
   
    public String autenticar(String nombre,String clave) {
        String sql = "SELECT tipo_usuario FROM usuarios WHERE nombre = ? AND clave = ?";
        List<String> resultados = jdbcTemplate.query(sql, new Object[]{nombre, clave}, (rs, rowNum) -> rs.getString("tipo_usuario"));

        // Si la lista de resultados no está vacía, significa que se encontró un tipo de usuario válido
        if (!resultados.isEmpty()) {
            return resultados.get(0); // Devuelve el primer tipo de usuario encontrado
        } else {
            return null; // Devuelve null si no se encontró ningún tipo de usuario
        }
    }

}
