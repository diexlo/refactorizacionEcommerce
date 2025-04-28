package com.inventario.infraestructure.adapter.output.persistence.repository;

import com.inventario.application.port.output.ProductoRepository;
import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.output.persistence.entity.ProductoEntity;
import com.inventario.infraestructure.adapter.output.persistence.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public  class ProductoRepositoryImpl implements ProductoRepository {

    private final SpringDataProductoRepository springDataProductoRepository;
    private final ProductoMapper productoMapper;
    @Override
    public Producto crearProducto(Producto producto) {
        ProductoEntity entity = productoMapper.mapToEntity(producto);
        entity.setNombre(producto.getNombre());
        entity.setDescripcion(producto.getDescripcion());
        ProductoEntity saved = springDataProductoRepository.save(entity);
        return productoMapper.mapToDomain(saved);
    }

    @Override
    public List<Producto> obtenerTodasProductos() {
        List<ProductoEntity> categoriesEntities=  springDataProductoRepository.findAll();

        return  categoriesEntities.stream()
                .map(productoMapper::mapToDomain)
                .collect(Collectors.toList());

        }
    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        Optional<ProductoEntity> categoriesEntities=  springDataProductoRepository.findById(id);

        return  categoriesEntities.map(productoMapper::mapToDomain);

    }

    @Override
    public boolean eliminarProducto(Long id) {
        if (springDataProductoRepository.existsById(id)) {
            springDataProductoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return springDataProductoRepository.existsByNombre(nombre);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return crearProducto(producto);
    }


}
