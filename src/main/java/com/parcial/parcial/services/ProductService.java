package com.parcial.parcial.services;

import com.parcial.parcial.dto.ProductRequestDTO;
import com.parcial.parcial.dto.ProductResponseDTO;
import com.parcial.parcial.entities.ProductEntity;
import com.parcial.parcial.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO){
        ProductEntity productToSave = ProductEntity.builder()
                .name(productRequestDTO.getName())
                .price(productRequestDTO.getPrice())
                .stock(productRequestDTO.getStock())
                .build();
        ProductEntity productSaved = productRepository.save(productToSave);
        ProductResponseDTO responseDTO = ProductResponseDTO.builder()
                .id(productSaved.getId())
                .price(productSaved.getPrice())
                .name(productSaved.getName())
                .stock(productSaved.getStock())
                .build();
        return responseDTO;
    }
}
