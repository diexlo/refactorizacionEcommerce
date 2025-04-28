package com.inventario.application.port.output;

import com.inventario.domain.model.Categoria;

import java.util.List;
import java.util.Optional;


public interface CategoriaRepository {
    //   Optional<Categoria> findByNombre(String nombre);
    //   boolean existsByNombre(String nombre);
    Categoria crearCategoria(Categoria categoria);

    List<Categoria> obtenerTodasCategorias();

    Optional<Categoria> obtenerCategoriaPorId(Long id);

    boolean eliminarCategoria(Long id);

    boolean existsByNombre(String nombre);

    Categoria guardarCategoria(Categoria categoria);
}