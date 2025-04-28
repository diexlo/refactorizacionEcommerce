package com.inventario.application.port.input;

import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.input.dto.request.ProductoRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductoUseCase {
    List<Producto> ObtenerTodosProductos();
    Optional<Producto> obtenerProductosPorId(Long id);
    Optional<Producto> obtenerProductosPorCategoria(Long categoriaId);
    boolean buscarProductosPorNombre(String Nombre);
    Optional<Producto> buscarPorRangoPrecio(BigDecimal min, BigDecimal max);
    Producto crearProducto(ProductoRequest cproductoRequest);
    Producto actualizarProducto(long id, Producto producto);
    Producto actualizarStock(long id, Integer stock);
    boolean eliminarProducto(Long id);

}