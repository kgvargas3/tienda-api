package com.example.tienda.exception;

// Se lanza cuando se busca o se elimina un producto cuyo id no existe (termina en HTTP 404).
public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(Long id) {
        super("No existe un producto con id " + id);
    }
}
