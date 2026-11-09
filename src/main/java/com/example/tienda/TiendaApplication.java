package com.example.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Punto de entrada. Al arrancar, Spring escanea este paquete y sus subpaquetes,
// y crea automaticamente los componentes (@Service, @RestController, etc.).
@SpringBootApplication
public class TiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaApplication.class, args);
    }
}
