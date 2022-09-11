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
}
