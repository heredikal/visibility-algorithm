package com.visibilityalgorithm.integration.dto;

import java.util.List;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private int sequence;
    private List<SizeDTO> sizeDTOs;
    
}