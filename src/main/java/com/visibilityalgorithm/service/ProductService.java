package com.visibilityalgorithm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.visibilityalgorithm.integration.dto.ProductDTO;

@Service
public interface ProductService {   
    List<ProductDTO> getVisibleProducts();
}
