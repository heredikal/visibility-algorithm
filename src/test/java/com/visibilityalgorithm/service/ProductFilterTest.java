package com.visibilityalgorithm.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.dto.SizeDTO;
import com.visibilityalgorithm.integration.dto.StockDTO;
import com.visibilityalgorithm.service.impl.ProductFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductFilterTest {

    private final ProductFilter productFilter = new ProductFilter();

    @Test
    public void testToFilterProductDTOs() {
        // Given
        List<ProductDTO> products = Arrays.asList(
                createProductDTO(1, Collections.singletonList(createSizeDTO(true, Collections.singletonList(createStockDTO(true))))),
                createProductDTO(2, Collections.singletonList(createSizeDTO(false, Collections.singletonList(createStockDTO(true))))),
                createProductDTO(3, Collections.singletonList(createSizeDTO(true, Collections.singletonList(createStockDTO(false))))),
                createProductDTO(4, Collections.singletonList(createSizeDTO(false, Collections.singletonList(createStockDTO(false))))),
                createProductDTO(5, Collections.singletonList(createSizeDTO(false, null)))
        );       

        // When
        List<ProductDTO> result = productFilter.toFilterProductDTOs(products);

        // Then
        Assertions.assertEquals(result.size(), 2);     
    }

    private ProductDTO createProductDTO(int id, List<SizeDTO> sizeDTOs) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setSizeDTOs(sizeDTOs);
        return productDTO;
    }

    private SizeDTO createSizeDTO(boolean isSpecial, List<StockDTO> stockDTOs) {
        SizeDTO sizeDTO = new SizeDTO();
        sizeDTO.setSpecial(isSpecial);
        sizeDTO.setStockDTOs(stockDTOs);
        return sizeDTO;
    }

    private StockDTO createStockDTO(boolean hasStock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setQuantity(hasStock ? 1 : 0);
        return stockDTO;
    }
}

