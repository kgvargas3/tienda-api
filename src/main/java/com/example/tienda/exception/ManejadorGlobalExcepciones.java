package com.example.tienda.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Aqui se atrapan, en un solo lugar, las excepciones lanzadas por cualquier endpoint.
// Asi el Controller y el Service no necesitan bloques try/catch.
@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    // Producto inexistente -> 404 Not Found
    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<ErrorRespuesta> manejarNoEncontrado(ProductoNoEncontradoException ex) {
        return construirRespuesta(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Datos que incumplen una regla de negocio -> 400 Bad Request
    @ExceptionHandler(ProductoInvalidoException.class)
    public ResponseEntity<ErrorRespuesta> manejarInvalido(ProductoInvalidoException ex) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    // Metodo auxiliar para no repetir la construccion del cuerpo de error.
    private ResponseEntity<ErrorRespuesta> construirRespuesta(HttpStatus estado, String mensaje) {
        ErrorRespuesta cuerpo = new ErrorRespuesta(estado.value(), mensaje, LocalDateTime.now());
        return ResponseEntity.status(estado).body(cuerpo);
    }
}
