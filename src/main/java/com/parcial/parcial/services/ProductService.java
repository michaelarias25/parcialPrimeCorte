package com.parcial.parcial.services;

import com.parcial.parcial.dto.ProductRequestDTO;
import com.parcial.parcial.dto.ProductResponseDTO;
import com.parcial.parcial.entities.ProductEntity;
import com.parcial.parcial.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // CREATE
    public ProductResponseDTO saveProduct(ProductRequestDTO requestDTO) {
        ProductEntity productToSave = ProductEntity.builder()
                .name(requestDTO.getName())
                .price(requestDTO.getPrice())
                .stock(requestDTO.getStock())
                .build();
        ProductEntity productSaved = productRepository.save(productToSave);
        return toDTO(productSaved);
    }

    // GET ALL
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // GET BY ID
    public ProductResponseDTO getProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return toDTO(product);
    }

    // UPDATE
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setName(requestDTO.getName());
        product.setPrice(requestDTO.getPrice());
        product.setStock(requestDTO.getStock());
        ProductEntity productUpdated = productRepository.save(product);
        return toDTO(productUpdated);
    }

    // DELETE
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    // Helper: Entity -> DTO
    private ProductResponseDTO toDTO(ProductEntity entity) {
        return ProductResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .build();
    }
}