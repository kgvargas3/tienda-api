package com.example.tienda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Producto;
import com.example.tienda.service.ProductoService;

// El Controller solo recibe las peticiones HTTP y devuelve las respuestas.
// No contiene reglas de negocio: eso lo hace el Service.
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    // Inyeccion por constructor: Spring crea el Service y lo entrega aqui,
    // por eso no se usa "new ProductoService()".
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET /api/productos -> 200 con la lista completa
    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    // GET /api/productos/{id} -> 200 con el producto (o 404 si no existe)
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    // POST /api/productos -> 201 con el producto creado (o 400 si es invalido)
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto creado = productoService.crear(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // DELETE /api/productos/{id} -> 204 sin cuerpo (o 404 si no existe)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
