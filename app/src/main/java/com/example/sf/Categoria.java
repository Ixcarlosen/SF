package com.example.sf;

public class Categoria {
    private String titulo;
    private String descripcion;

    private int imagenId;

    public Categoria(String titulo, String descripcion, int imagenId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenId = imagenId;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String genero) {
        this.descripcion = genero;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
