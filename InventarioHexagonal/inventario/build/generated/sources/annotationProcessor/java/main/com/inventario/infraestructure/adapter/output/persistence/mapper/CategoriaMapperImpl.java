package com.inventario.infraestructure.adapter.output.persistence.mapper;

import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.output.persistence.entity.CategoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-27T21:14:13-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria mapToDomain(CategoriaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( entity.getId() );
        categoria.setNombre( entity.getNombre() );
        categoria.setDescripcion( entity.getDescripcion() );

        return categoria;
    }

    @Override
    public CategoriaEntity mapToEntity(Categoria category) {
        if ( category == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setId( category.getId() );
        categoriaEntity.setNombre( category.getNombre() );
        categoriaEntity.setDescripcion( category.getDescripcion() );

        return categoriaEntity;
    }
}
