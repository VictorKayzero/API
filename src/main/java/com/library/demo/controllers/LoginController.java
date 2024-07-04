package com.library.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.jdbc.LoginJdbcRepository;
import com.library.demo.jdbc.Usuario;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/login")
@Tag(name ="LoginController")
public class LoginController {


    @Autowired
    private LoginJdbcRepository loginJdbcRepository;

    //considerar agregar encriptación para las claves
    @CrossOrigin(origins= "http://localhost:3000")
    @PostMapping
    public ResponseEntity<String> login(@RequestBody Usuario usu) {
    	String result = loginJdbcRepository.autenticar(usu.getNombre(), usu.getClave());

    	if (result!=null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }

}