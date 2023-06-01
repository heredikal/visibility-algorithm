package com.visibilityalgorithm.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.utils.Fixtures;
import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.entity.ProductEntity;
import com.visibilityalgorithm.integration.mapper.ProductMapper;
import com.visibilityalgorithm.integration.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductFilter productFilter;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository, productMapper, productFilter);
    }

    @Test
    public void testGetVisibleProducts() {
        // Given
        List<ProductEntity> products = Fixtures.getList(ProductEntity.class, 3);
        
        when(productRepository.findAll()).thenReturn(products);

        // When
        List<ProductDTO> result = productService.getVisibleProducts();

        // Then
        assertNotNull(result);
    }
}

