package com.visibilityalgorithm.integration.dto;

import lombok.Data;

@Data
public class StockDTO {
    private int id;
    private int quantity;
    private SizeDTO sizeDTO;
    
}