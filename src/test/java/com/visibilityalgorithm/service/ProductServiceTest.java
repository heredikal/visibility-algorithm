package com.visibilityalgorithm.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.utils.Fixtures;
import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.entity.ProductEntity;
import com.visibilityalgorithm.integration.mapper.ProductMapper;
import com.visibilityalgorithm.integration.repository.ProductRepository;
import com.visibilityalgorithm.service.impl.ProductFilter;
import com.visibilityalgorithm.service.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductFilter productFilter;

    private ProductServiceImpl productService;

    @BeforeEach
    void setup() {        
        productService = new ProductServiceImpl(productRepository, productMapper, productFilter);
    }

    @Test
    void testGetVisibleProducts() {
        // Given
        List<ProductEntity> products = Fixtures.getList(ProductEntity.class, 3);
        
        when(productRepository.findAll()).thenReturn(products);

        // When
        List<ProductDTO> result = productService.getVisibleProducts();

        // Then
        assertNotNull(result);
    }
}

