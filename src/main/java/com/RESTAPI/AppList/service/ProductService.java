package com.RESTAPI.AppList.service;

import com.RESTAPI.AppList.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto addAmount(Long id, double amount);

    ProductDto reduceAmount(Long id, double amount);

    ProductDto changePrise(Long id, double prise);

    List<ProductDto> getProductsByProperty(String property , String value);


}
