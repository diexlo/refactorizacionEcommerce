package com.inventario.application.port.output;

import com.inventario.domain.model.Producto;

import java.util.List;
import java.util.Optional;


public interface ProductoRepository {
    //   Optional<Producto> findByNombre(String nombre);
    //   boolean existsByNombre(String nombre);
    Producto crearProducto(Producto producto);

    List<Producto> obtenerTodasProductos();

    Optional<Producto> obtenerProductoPorId(Long id);

    boolean eliminarProducto(Long id);

    boolean existsByNombre(String nombre);

    Producto guardarProducto(Producto producto);
}