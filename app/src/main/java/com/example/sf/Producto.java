package com.example.sf;

public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String marca;
    private String tiendaid;
    private int imagen;

    public Producto (String nombre, String descripcion, String precio,String marca, int imagen){
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.marca=marca;
        this.imagen=imagen;
    }
    public Producto() {
        this.id = "";
        this.tiendaid = "";
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getImagen() {
        return imagen;
    }
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public String getTiendaId() {
        return tiendaid;
    }
    public void setTiendaId(String tiendaId) {
        this.tiendaid = tiendaId;
    }
}
