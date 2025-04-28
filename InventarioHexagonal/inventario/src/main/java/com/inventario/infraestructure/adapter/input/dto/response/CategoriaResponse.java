package com.inventario.infraestructure.adapter.input.dto.response;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class CategoriaResponse extends ResponseEntity {
    public CategoriaResponse(HttpStatusCode status) {
        super(status);
    }
}
