package com.parcial.parcial.controller;

import com.parcial.parcial.dto.ProductRequestDTO;
import com.parcial.parcial.dto.ProductResponseDTO;
import com.parcial.parcial.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("create")
    public ProductResponseDTO saveProduct(@RequestBody ProductRequestDTO requestDTO){
        return productService.saveProduct(requestDTO);
    }
}
