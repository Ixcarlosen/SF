package com.example.sf;

public class Tienda {

    private String id;
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

    public Tienda() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono =telefono;
    }


    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
