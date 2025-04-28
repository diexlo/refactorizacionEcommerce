package com.inventario.application.service;

import com.inventario.application.port.input.CategoriaUseCase;
import com.inventario.application.port.output.CategoriaRepository;
import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.input.dto.request.CategoriaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService implements CategoriaUseCase {
    private  final CategoriaRepository categoriaRepository;

    @Override
    public Categoria crearCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequest.getNombre());
        categoria.setDescripcion(categoriaRequest.getDescripcion());
        return categoriaRepository.crearCategoria(categoria);
    }
    @Override
    public List<Categoria> obtenerTodasCategorias(){
        return  categoriaRepository.obtenerTodasCategorias();
    }
    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return categoriaRepository.obtenerCategoriaPorId(id);
    }

    @Override
    public boolean eliminarCategoria(Long id) {
        return categoriaRepository.eliminarCategoria(id);
    }
    @Override
    public boolean existePorNombre(String nombre) {
        return categoriaRepository.existsByNombre(nombre);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.guardarCategoria(categoria);
    }


    /*
    public List<Categoria> obtenerTodasCategorias() {
        return categoriaRepository.findAll();
    }



    public Optional<Categoria> obtenerCategoriaPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    @Transactional
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public boolean eliminarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

 */
}
