package com.inventario.application.service;

import com.inventario.application.port.input.ProductoUseCase;
import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.input.dto.request.ProductoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService implements ProductoUseCase {
    @Override
    public List<Producto> ObtenerTodosProductos() {
        return List.of();
    }

    @Override
    public Optional<Producto> obtenerProductosPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> obtenerProductosPorCategoria(Long categoriaId) {
        return Optional.empty();
    }

    @Override
    public boolean buscarProductosPorNombre(String Nombre) {
        return true;
    }

    @Override
    public Optional<Producto> buscarPorRangoPrecio(BigDecimal min, BigDecimal max) {
        return Optional.empty();
    }

    @Override
    public Producto crearProducto(ProductoRequest cproductoRequest) {
        return null;
    }

    @Override
    public Producto actualizarProducto(long id, Producto producto) {
        return null;
    }

    @Override
    public Producto actualizarStock(long id, Integer stock) {
        return null;
    }

    @Override
    public boolean eliminarProducto(Long id) {
        return false;
    }
}
