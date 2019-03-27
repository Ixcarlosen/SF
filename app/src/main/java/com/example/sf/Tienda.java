package com.example.sf;

public class Tienda {


    private String titulo;
    private String descripcion;
    private String telefono;
    private int imagenId;

    public Tienda(String titulo, String descripcion, String telefono, int imagenId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String año) {
        this.telefono = año;
    }


    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
