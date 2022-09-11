package com.ejercicios456.ejercicios456.controlador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${app.message}")
    String mensaje;
    @GetMapping("/hola")
    public String holaMundo (){
        String str = "Hola Mundo desde Argentina, Salta!!! " + mensaje;
        return str;
    }

    @GetMapping("/admin")
    public String admin (){

        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                </head>
                <body>
                    <h3 style="font-size: 45px; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; color:rgb(64, 131, 109)">
                        Ejercicio 10 11 12 de OpenBootCamp Curso de Spring Clase 12
                    </h3>
                </body>
                </html>
                """;
    }
}
