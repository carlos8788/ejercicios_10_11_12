package com.ejercicios456.ejercicios456;

import com.ejercicios456.ejercicios456.entidades.Laptop;
import com.ejercicios456.ejercicios456.repositorios.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Ejercicios456Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicios456Application.class, args);
		LaptopRepository repositorio = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Lenovo", "8gb", "AMD Ryzen 5 ", "1tb", "Windows 10",1000, true);

		repositorio.save(laptop1);
		Laptop laptop2= new Laptop(null, "Apple", "16gb", "M1 ", "512gb", "MacOS",2000, true);

		repositorio.save(laptop2);

		System.out.println("Num laptos en base de datos: " + repositorio.findAll());

	}

}
