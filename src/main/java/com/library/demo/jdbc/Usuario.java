package com.library.demo.jdbc;

public class Usuario {

    private String nombre;
    private String clave;

    // Constructores, getters y setters

    public Usuario(Long id_libro, String nombre, String clave) {

        this.nombre = nombre;
        this.clave = clave;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

    
}