package com.inventario.infraestructure.adapter.output.persistence.repository;

import com.inventario.domain.model.Categoria;
import com.inventario.infraestructure.adapter.output.persistence.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataCategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    boolean existsByNombre(String nombre);
    Optional<Categoria> findByNombre(String nombre);
}
