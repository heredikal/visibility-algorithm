package com.visibilityalgorithm.integration.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.visibilityalgorithm.integration.dto.ProductDTO;
import com.visibilityalgorithm.integration.dto.SizeDTO;
import com.visibilityalgorithm.integration.dto.StockDTO;
import com.visibilityalgorithm.integration.entity.ProductEntity;
import com.visibilityalgorithm.integration.entity.SizeEntity;
import com.visibilityalgorithm.integration.entity.StockEntity;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    private ProductMapper productMapper;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        productMapper = new ProductMapper(modelMapper);
    }

    @Test
    void testToDto() {

        // Given
        ProductEntity productEntity = createMockProductEntity();
        SizeEntity sizeEntity = createMockSizeEntity(productEntity);
        StockEntity stockEntity = createMockStockEntity(sizeEntity);
        ProductDTO productDTO = createMockProductDTO();
        SizeDTO sizeDTO = createMockSizeDTO();
        StockDTO stockDTO = createMockStockDTO();

        List<SizeEntity> sizes = new ArrayList<>();
        sizes.add(sizeEntity);
        productEntity.setSizes(sizes);

        List<StockEntity> stocks = new ArrayList<>();
        stocks.add(stockEntity);
        sizeEntity.setStocks(stocks);

        List<SizeDTO> sizeDTOs = new ArrayList<>();
        sizeDTOs.add(sizeDTO);
        productDTO.setSizeDTOs(sizeDTOs);

        List<StockDTO> stockDTOs = new ArrayList<>();
        stockDTOs.add(stockDTO);
        sizeDTO.setStockDTOs(stockDTOs);

        when(modelMapper.map(productEntity, ProductDTO.class)).thenReturn(productDTO);
        when(modelMapper.map(sizeEntity, SizeDTO.class)).thenReturn(sizeDTO);
        when(modelMapper.map(stockEntity, StockDTO.class)).thenReturn(stockDTO);

        // When
        ProductDTO mappedProductDTO = productMapper.toDto(productEntity);

        // Then
        assertEquals(productDTO.getId(), mappedProductDTO.getId());
        assertEquals(productDTO.getSequence(), mappedProductDTO.getSequence());
        assertEquals(productDTO.getSizeDTOs().size(), mappedProductDTO.getSizeDTOs().size());

        SizeDTO mappedSizeDTO = mappedProductDTO.getSizeDTOs().get(0);
        assertEquals(sizeDTO.getId(), mappedSizeDTO.getId());
        assertEquals(sizeDTO.isBackSoon(), mappedSizeDTO.isBackSoon());
        assertEquals(sizeDTO.isSpecial(), mappedSizeDTO.isSpecial());
        assertEquals(sizeDTO.getStockDTOs().size(), mappedSizeDTO.getStockDTOs().size());

        StockDTO mappedStockDTO = mappedSizeDTO.getStockDTOs().get(0);
        assertEquals(stockDTO.getId(), mappedStockDTO.getId());
        assertEquals(stockDTO.getQuantity(), mappedStockDTO.getQuantity());
    }

    private ProductEntity createMockProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setSequence(123);
        return productEntity;
    }

    private SizeEntity createMockSizeEntity(ProductEntity productEntity) {
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setId(1);
        sizeEntity.setProduct(productEntity);
        sizeEntity.setBackSoon(true);
        sizeEntity.setSpecial(false);
        return sizeEntity;
    }

    private StockEntity createMockStockEntity(SizeEntity sizeEntity) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setId(1);
        stockEntity.setSize(sizeEntity);
        stockEntity.setQuantity(10);
        return stockEntity;
    }

    private ProductDTO createMockProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1);
        productDTO.setSequence(123);
        return productDTO;
    }

    private SizeDTO createMockSizeDTO() {
        SizeDTO sizeDTO = new SizeDTO();
        sizeDTO.setId(1);
        sizeDTO.setBackSoon(true);
        sizeDTO.setSpecial(false);
        return sizeDTO;
    }

    private StockDTO createMockStockDTO() {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(1);
        stockDTO.setQuantity(10);
        return stockDTO;
    }

}
