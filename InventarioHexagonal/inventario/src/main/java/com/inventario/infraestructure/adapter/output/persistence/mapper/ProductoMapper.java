package com.inventario.infraestructure.adapter.output.persistence.mapper;

import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.output.persistence.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    // Category mappings
    Producto mapToDomain(ProductoEntity entity);

    ProductoEntity mapToEntity(Producto producto);


}
