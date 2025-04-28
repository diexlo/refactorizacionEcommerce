package com.inventario.infraestructure.adapter.output.persistence.repository;

import com.inventario.application.port.output.CategoriaRepository;
import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.output.persistence.entity.CategoriaEntity;
import com.inventario.infraestructure.adapter.output.persistence.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;



@Component
@RequiredArgsConstructor
public  class CategoriaRepositoryImpl implements CategoriaRepository {

    private final SpringDataCategoriaRepository springDataCategoriaRepository;
    private final CategoriaMapper categoriaMapper;
    @Override
    public Categoria crearCategoria(Categoria categoria) {
        CategoriaEntity entity = categoriaMapper.mapToEntity(categoria);
        CategoriaEntity saved = springDataCategoriaRepository.save(entity);
        return categoriaMapper.mapToDomain(saved);
    }

    @Override
    public List<Categoria> obtenerTodasCategorias() {
        List<CategoriaEntity> categoriesEntities=  springDataCategoriaRepository.findAll();

        return  categoriesEntities.stream()
                .map(categoriaMapper::mapToDomain)
                .collect(Collectors.toList());

        }
    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        Optional<CategoriaEntity> categoriesEntities=  springDataCategoriaRepository.findById(id);

        return  categoriesEntities.map(categoriaMapper::mapToDomain);

    }

    @Override
    public boolean eliminarCategoria(Long id) {
        if (springDataCategoriaRepository.existsById(id)) {
            springDataCategoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return springDataCategoriaRepository.existsByNombre(nombre);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return crearCategoria(categoria);
    }


}
