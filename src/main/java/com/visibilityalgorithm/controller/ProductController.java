package com.visibilityalgorithm.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/visible")
    @Operation( summary = "Devuelve informacion de los prodcutos segun algoritmo de visibilidad" )    
    @ApiResponses( value = {
        @ApiResponse( responseCode = "200", description = "Se actualizara la escala, devuelve la escala actualizada",
            content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema( implementation = ProductDTO.class ) ) )
    } )
    public List<ProductDTO> getVisibleProducts() {
        return productService.getVisibleProducts();
    }

}

