package com.visibilityalgorithm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.utils.Fixtures;
import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.service.ProductService;

@SpringJUnitConfig
@WebMvcTest(ProductController.class)
public class ProductControllerTest {    

    @MockBean
    private ProductService productService;
    @Test
    public void testGetVisibleProducts() throws Exception {

        // Given
        List<ProductDTO> expectedProducts = Fixtures.getList(ProductDTO.class, 3);

        when(productService.getVisibleProducts()).thenReturn(expectedProducts);

        // When
        ProductController productController = new ProductController(productService);
        List<ProductDTO> response = productController.getVisibleProducts();

        // Then
        assertEquals(response.size(), expectedProducts.size());
    }
}
