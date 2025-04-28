package com.inventario.infraestructure.adapter.input.dto.request;

import com.inventario.domain.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    private Integer stock;

    private Categoria categoria;

    private String codigoSku;
}
