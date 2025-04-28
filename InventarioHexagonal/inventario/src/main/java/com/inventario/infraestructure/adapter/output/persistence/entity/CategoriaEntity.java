package com.inventario.infraestructure.adapter.output.persistence.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String descripcion;

    //@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    //private List<Producto> productos = new ArrayList<>();




   /* public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }*/
}

