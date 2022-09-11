package com.ejercicios456.ejercicios456.repositorios;

import com.ejercicios456.ejercicios456.entidades.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
