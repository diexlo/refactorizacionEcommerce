package com.inventario.infraestructure.adapter.input.rest;

import com.inventario.application.port.input.CategoriaUseCase;
import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.input.dto.request.CategoriaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaUseCase categoriaUseCase;
    CategoriaController (final CategoriaUseCase categoriaUseCase) {

        this.categoriaUseCase = categoriaUseCase;
    }
    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        if (categoriaUseCase.existePorNombre(categoriaRequest.getNombre())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Categoria nuevaCategoria = categoriaUseCase.crearCategoria(categoriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);

    }
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodasCategorias() {
        List<Categoria> categorias = categoriaUseCase.obtenerTodasCategorias();

        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> obtenerCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categorias = categoriaUseCase.obtenerCategoriaPorId(id);

        return ResponseEntity.ok(categorias);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        boolean eliminado = categoriaUseCase.eliminarCategoria(id);

        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> categoriaExistente = categoriaUseCase.obtenerCategoriaPorId(id);

        if (categoriaExistente.isPresent()) {
            Categoria categoriaActualizar = categoriaExistente.get();

            // Verificar si el nombre ya existe y es diferente al actual
            if (!categoriaActualizar.getNombre().equals(categoria.getNombre()) &&
                    categoriaUseCase.existePorNombre(categoria.getNombre())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            categoriaActualizar.setNombre(categoria.getNombre());
            categoriaActualizar.setDescripcion(categoria.getDescripcion());

            return ResponseEntity.ok(categoriaUseCase.actualizarCategoria(categoriaActualizar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


