package com.example.tienda.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.tienda.exception.ProductoInvalidoException;
import com.example.tienda.exception.ProductoNoEncontradoException;
import com.example.tienda.model.Producto;

// @Service le dice a Spring que cree y administre una unica instancia de esta clase.
// Aqui viven las reglas de negocio y el almacenamiento en memoria.
@Service
public class ProductoService {

    // "Base de datos" temporal: se pierde al detener la aplicacion.
    private final Map<Long, Producto> productos = new LinkedHashMap<>();

    // Contador para asignar ids automaticamente.
    private long siguienteId = 1;

    // Algunos datos iniciales para poder probar los GET sin registrar nada antes.
    public ProductoService() {
        crear(new Producto(null, "Laptop", 850.50, 10));
        crear(new Producto(null, "Mouse", 15.99, 50));
        crear(new Producto(null, "Teclado", 35.00, 25));
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }

    public Producto buscarPorId(Long id) {
        Producto producto = productos.get(id);
        if (producto == null) {
            throw new ProductoNoEncontradoException(id);
        }
        return producto;
    }

    public Producto crear(Producto producto) {
        validar(producto);
        // El id lo asigna el servidor, se ignora cualquier id enviado por el cliente.
        producto.setId(siguienteId++);
        productos.put(producto.getId(), producto);
        return producto;
    }

    public void eliminar(Long id) {
        // Si no existe, buscarPorId lanza la excepcion y no se llega a eliminar.
        buscarPorId(id);
        productos.remove(id);
    }

    // Reglas de negocio para registrar un producto.
    private void validar(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new ProductoInvalidoException("El nombre del producto es obligatorio");
        }
        if (producto.getPrecio() <= 0) {
            throw new ProductoInvalidoException("El precio debe ser mayor a cero");
        }
        if (producto.getStock() < 0) {
            throw new ProductoInvalidoException("El stock no puede ser negativo");
        }
    }
}
