package com.inventario.infraestructure.adapter.output.persistence.mapper;

import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.input.dto.request.CategoriaRequest;
import com.inventario.infraestructure.adapter.output.persistence.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    // Category mappings
    Categoria mapToDomain(CategoriaEntity entity);

    CategoriaEntity mapToEntity(Categoria category);


}
