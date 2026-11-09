package com.example.tienda.model;

// Representa un producto de la tienda. Es una clase simple que solo guarda datos.
public class Producto {

    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    // Spring necesita un constructor vacio para convertir el JSON recibido en un objeto Producto.
    public Producto() {
    }

    public Producto(Long id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
