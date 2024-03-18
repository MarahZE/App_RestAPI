package com.RESTAPI.AppList.service;

import com.RESTAPI.AppList.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();
}
