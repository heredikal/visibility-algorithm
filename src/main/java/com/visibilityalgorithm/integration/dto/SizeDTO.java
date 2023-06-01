package com.visibilityalgorithm.integration.dto;

import java.util.List;
import lombok.Data;

@Data
public class SizeDTO {
    private int id;
    private boolean backSoon;
    private boolean special;
    private List<ProductDTO> productDTOs;
    private List<StockDTO> stockDTOs;
}