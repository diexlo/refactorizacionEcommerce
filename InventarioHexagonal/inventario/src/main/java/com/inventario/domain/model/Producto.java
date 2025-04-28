package com.inventario.domain.model;


import java.math.BigDecimal;

import lombok.Getter;

import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor

public class Producto {

    private Long id;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private Integer stock;

    private Categoria categoria;

    private String codigoSku;


/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    // Constructores
    public Producto() {
    }

    public Producto(String nombre, String descripcion, BigDecimal precio, Integer stock, Categoria categoria, String codigoSku) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.codigoSku = codigoSku;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

 */
}