package com.inventario.infraestructure.adapter.input.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {
    private Long id;
    private String nombre;
    private String descripcion;

}
