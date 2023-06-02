package com.visibilityalgorithm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.dto.SizeDTO;
import com.visibilityalgorithm.integration.dto.StockDTO;

@Component
public class ProductFilter {

    public List<ProductDTO> toFilterProductDTOs(List<ProductDTO> products) {
        return products.stream()
                .filter(this::hasAvailableSize)
                .collect(Collectors.toList());
    }

    private boolean hasAvailableSize(ProductDTO product) {
        List<SizeDTO> sizes = product.getSizeDTOs();
        if (sizes == null || sizes.isEmpty()) {
            return false;
        }

        boolean hasSpecialSize = false;
        boolean hasNonSpecialSize = false;
        boolean hasNonSpecialSizeWithStock = false;

        for (SizeDTO size : sizes) {
            if (hasStockOrBackSoon(size)) {
                if (size.isSpecial()) {
                    hasSpecialSize = true;
                } else {
                    hasNonSpecialSize = true;
                    if (hasStock(size)) {
                        hasNonSpecialSizeWithStock = true;
                    }
                }
            }
        }

        return (hasSpecialSize && hasNonSpecialSizeWithStock) || (!hasSpecialSize && hasNonSpecialSize);
    }

    private boolean hasStockOrBackSoon(SizeDTO size) {
        List<StockDTO> stocks = size.getStockDTOs();
        return size.isBackSoon() || (stocks != null && !stocks.isEmpty());
    }

    private boolean hasStock(SizeDTO size) {
        List<StockDTO> stocks = size.getStockDTOs();
        return stocks != null && stocks.stream().anyMatch(stock -> stock.getQuantity() > 0);
    }
}

