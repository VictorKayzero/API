package com.library.demo.jdbc;

public class Libro {
    private Long id_libro;
    private String titulo;
    private String autor;

    // Constructores, getters y setters

    public Libro(Long id_libro, String titulo, String autor) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.autor = autor;
    }

	public Long getId() {
		return id_libro;
	}

	public void setId(Long id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

    // Getters y setters
    
}