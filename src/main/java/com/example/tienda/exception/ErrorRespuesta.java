package com.example.tienda.exception;

import java.time.LocalDateTime;

// Formato unico de las respuestas de error: codigo HTTP, mensaje y momento en que ocurrio.
public record ErrorRespuesta(int estado, String mensaje, LocalDateTime fecha) {
}
