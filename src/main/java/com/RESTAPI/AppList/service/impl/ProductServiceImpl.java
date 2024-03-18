package com.RESTAPI.AppList.service.impl;

import com.RESTAPI.AppList.dto.ProductDto;
import com.RESTAPI.AppList.entity.Product;
import com.RESTAPI.AppList.mapper.ProductMapper;
import com.RESTAPI.AppList.repository.ProductRepository;
import com.RESTAPI.AppList.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product dose not found!"));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productDtoList = productRepository.findAll();
        return productDtoList.stream().map( (product) -> ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
    }
}
