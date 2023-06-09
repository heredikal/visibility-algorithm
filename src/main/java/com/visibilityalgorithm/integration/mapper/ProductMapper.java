package com.visibilityalgorithm.integration.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.dto.SizeDTO;
import com.visibilityalgorithm.integration.dto.StockDTO;
import com.visibilityalgorithm.integration.entity.ProductEntity;
import com.visibilityalgorithm.integration.entity.SizeEntity;
import com.visibilityalgorithm.integration.entity.StockEntity;

@Component
public class ProductMapper {

    private ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO toDto(ProductEntity productEntity) {
        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
        List<SizeDTO> sizeDTOs = productEntity.getSizes().stream().map(this::toDto).collect(Collectors.toList());
        productDTO.setSizeDTOs(sizeDTOs);
        return productDTO;
    }

    public SizeDTO toDto(SizeEntity sizeEntity) {
        SizeDTO sizeDTO = modelMapper.map(sizeEntity, SizeDTO.class);
        List<StockDTO> stockDTOs = sizeEntity.getStocks().stream().map(this::toDto).collect(Collectors.toList());
        sizeDTO.setStockDTOs(stockDTOs);
        return sizeDTO;
    }

    public StockDTO toDto(StockEntity stockEntity) {
        return modelMapper.map(stockEntity, StockDTO.class);
    }

}
