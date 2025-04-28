package com.inventario.application.port.input;

import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.input.dto.request.CategoriaRequest;


import java.util.List;
import java.util.Optional;

public interface CategoriaUseCase {
    Categoria crearCategoria(CategoriaRequest categoriaRequest);
    List<Categoria> obtenerTodasCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    boolean eliminarCategoria(Long id);
    boolean existePorNombre(String nombre);
    Categoria actualizarCategoria(Categoria categoria);
}
