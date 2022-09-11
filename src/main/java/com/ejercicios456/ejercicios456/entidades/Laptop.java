package com.ejercicios456.ejercicios456.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "laptos")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String ram;
    private String procesador;
    private String capacidad;
    private String sistemaOperativo;

    private double precio;
    private Boolean online;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String ram, String procesador, String capacidad, String sistemaOperativo,double precio, Boolean online) {
        this.id = id;
        this.marca = marca;
        this.ram = ram;
        this.procesador = procesador;
        this.capacidad = capacidad;
        this.sistemaOperativo = sistemaOperativo;
        this.precio = precio;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", ram='" + ram + '\'' +
                ", procesador='" + procesador + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", precio=" + precio +
                ", online=" + online +
                '}';
    }
}
