package com.ejercicios456.ejercicios456.controlador;

import com.ejercicios456.ejercicios456.entidades.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
    /*
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =  testRestTemplate.getForEntity("/api/laptos", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Laptop> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response =  testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }
    */

    @DisplayName("Estoy testeando como crear una laptop")
    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "marca": "Compaq",
                    "ram": "8gb",
                    "procesador": "intel I3 ",
                    "capacidad": "256gb",
                    "sistemaOperativo": "Windows 10",
                    "precio": 800,
                    "online": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
        assertEquals(1L, result.getId());

    }

}