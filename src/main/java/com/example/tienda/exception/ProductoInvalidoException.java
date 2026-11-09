package com.example.tienda.exception;

// Se lanza cuando los datos de un producto incumplen una regla de negocio (termina en HTTP 400).
public class ProductoInvalidoException extends RuntimeException {

    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
