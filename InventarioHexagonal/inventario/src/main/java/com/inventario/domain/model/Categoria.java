package com.inventario.domain.model;


import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Long id;

    private String nombre;

    private String descripcion;

    //private List<Producto> productos = new ArrayList<>();

    // Constructores
    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    //public List<Producto> getProductos() {
    //    return productos;
    //}

    //public void setProductos(List<Producto> productos) {
      //  this.productos = productos;
    //}
}