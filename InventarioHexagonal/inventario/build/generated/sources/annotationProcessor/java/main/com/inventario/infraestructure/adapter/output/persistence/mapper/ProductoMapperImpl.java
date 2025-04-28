package com.inventario.infraestructure.adapter.output.persistence.mapper;

import com.inventario.domain.model.Categoria;
import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.output.persistence.entity.CategoriaEntity;
import com.inventario.infraestructure.adapter.output.persistence.entity.ProductoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-27T21:14:13-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public Producto mapToDomain(ProductoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( entity.getId() );
        producto.setNombre( entity.getNombre() );
        producto.setDescripcion( entity.getDescripcion() );
        producto.setPrecio( entity.getPrecio() );
        producto.setStock( entity.getStock() );
        producto.setCategoria( categoriaEntityToCategoria( entity.getCategoria() ) );
        producto.setCodigoSku( entity.getCodigoSku() );

        return producto;
    }

    @Override
    public ProductoEntity mapToEntity(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setId( producto.getId() );
        productoEntity.setNombre( producto.getNombre() );
        productoEntity.setDescripcion( producto.getDescripcion() );
        productoEntity.setPrecio( producto.getPrecio() );
        productoEntity.setStock( producto.getStock() );
        productoEntity.setCategoria( categoriaToCategoriaEntity( producto.getCategoria() ) );
        productoEntity.setCodigoSku( producto.getCodigoSku() );

        return productoEntity;
    }

    protected Categoria categoriaEntityToCategoria(CategoriaEntity categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaEntity.getId() );
        categoria.setNombre( categoriaEntity.getNombre() );
        categoria.setDescripcion( categoriaEntity.getDescripcion() );

        return categoria;
    }

    protected CategoriaEntity categoriaToCategoriaEntity(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setId( categoria.getId() );
        categoriaEntity.setNombre( categoria.getNombre() );
        categoriaEntity.setDescripcion( categoria.getDescripcion() );

        return categoriaEntity;
    }
}
