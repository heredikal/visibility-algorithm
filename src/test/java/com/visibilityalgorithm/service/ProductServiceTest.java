package com.visibilityalgorithm.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.utils.Fixtures;
import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.entity.ProductEntity;
import com.visibilityalgorithm.integration.mapper.ProductMapper;
import com.visibilityalgorithm.integration.repository.ProductRepository;
import com.visibilityalgorithm.service.impl.ProductFilter;
import com.visibilityalgorithm.service.impl.ProductServiceImpl;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductFilter productFilter;

    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository, productMapper, productFilter);
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

