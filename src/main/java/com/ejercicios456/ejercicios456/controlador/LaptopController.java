package com.ejercicios456.ejercicios456.controlador;

import com.ejercicios456.ejercicios456.entidades.Laptop;
import com.ejercicios456.ejercicios456.repositorios.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> bookOpt = laptopRepository.findById(id);

        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop book, @RequestHeader HttpHeaders headers) {

        System.out.println(headers.get("User-Agent"));

        return laptopRepository.save(book);

    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

        if(laptop.getId() == null){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)) {
            log.warn("trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
