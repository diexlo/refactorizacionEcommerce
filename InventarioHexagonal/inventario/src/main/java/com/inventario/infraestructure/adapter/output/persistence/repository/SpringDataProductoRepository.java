package com.inventario.infraestructure.adapter.output.persistence.repository;

import com.inventario.domain.model.Producto;
import com.inventario.infraestructure.adapter.output.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataProductoRepository extends JpaRepository<ProductoEntity, Long> {
    boolean existsByNombre(String nombre);
    Optional<Producto> findByNombre(String nombre);
}
