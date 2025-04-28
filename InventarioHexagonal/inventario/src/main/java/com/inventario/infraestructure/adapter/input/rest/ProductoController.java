package com.inventario.infraestructure.adapter.input.rest;

import com.inventario.application.port.input.ProductoUseCase;
import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.input.dto.request.ProductoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoUseCase productoUseCase;
    ProductoController(final ProductoUseCase productoUseCase) {

        this.productoUseCase = productoUseCase;
    }
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest productoRequest) {
        if (productoUseCase.buscarProductosPorNombre(productoRequest.getNombre())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Producto nuevaProducto = productoUseCase.crearProducto(productoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaProducto);

    }
    @GetMapping
    public ResponseEntity<List<Producto>> ObtenerTodosProductos() {
        List<Producto> productos = productoUseCase.ObtenerTodosProductos();

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> productos = productoUseCase.obtenerProductosPorId(id);

        return ResponseEntity.ok(productos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoUseCase.eliminarProducto(id);

        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Optional<Producto> productoExistente = productoUseCase.obtenerProductosPorId(id);

        if (productoExistente.isPresent()) {
            Producto productoActualizar = productoExistente.get();

            // Verificar si el nombre ya existe y es diferente al actual
            if (!productoActualizar.getNombre().equals(producto.getNombre()) &&
                    productoUseCase.buscarProductosPorNombre(producto.getNombre())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            productoActualizar.setNombre(producto.getNombre());
            productoActualizar.setDescripcion(producto.getDescripcion());

            return ResponseEntity.ok(productoUseCase.actualizarProducto(id, productoActualizar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


