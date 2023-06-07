package com.visibilityalgorithm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.utils.Fixtures;
import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {    
    
    @Mock
    private ProductService productService;

    private ProductController productController;
    
    @BeforeEach
    void beforeEach(){
        productController = new ProductController(productService);
    }

    @Test
    void testGetVisibleProducts(){

        // Given        
        List<ProductDTO> expectedProducts = Fixtures.getList(ProductDTO.class, 3);
        when(productService.getVisibleProducts()).thenReturn(expectedProducts);

        // When        
        List<ProductDTO> response = productController.getVisibleProducts();

        // Then
        assertEquals(response.size(), expectedProducts.size());
    }
}
