package com.RESTAPI.AppList.service.impl;

import com.RESTAPI.AppList.dto.ProductDto;
import com.RESTAPI.AppList.entity.Product;
import com.RESTAPI.AppList.mapper.ProductMapper;
import com.RESTAPI.AppList.repository.ProductRepository;
import com.RESTAPI.AppList.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public ProductDto addAmount(Long id, double amount) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product dose not found!"));
        double total = product.getAmount() + amount;
        product.setAmount(total);

        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto reduceAmount(Long id, double amount) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product dose not found!"));
        if(amount > product.getAmount()) {
            throw  new RuntimeException("Wrong!");
        }
        double total = product.getAmount() - amount;
        product.setAmount(total);

        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto changePrise(Long id, double prise) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product dose not found!"));
        product.setPrice(prise);

        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getProductsByProperty(String property , String value) {
        List<Product> products = productRepository.findAll();

        List<Product> newList = new ArrayList<>();

        switch (property) {
            case "colour":
                for(Product product: products) {
                    if(product.getColour().equals(value)) {
                        newList.add(product);
                    }
                }
                break;
            case "name" :
                for(Product product: products) {
                    if(product.getName().equals(value)) {
                        newList.add(product);
                    }
                }
                break;
            default:
                throw new RuntimeException("Wrong property");
        }

        return newList.stream().map((product) -> ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product dose not found!"));

        productRepository.delete(product);
    }
}
