package com.visibilityalgorithm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.mapper.ProductMapper;
import com.visibilityalgorithm.integration.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductFilter productFilter;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ProductFilter productFilter) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productFilter = productFilter;
    }

    public List<ProductDTO> getVisibleProducts() {

        List<ProductDTO> products = productRepository.findAll().stream().map(productMapper::toDto).toList();
        return productFilter.toFilterProductDTOs(products);

    }
}
