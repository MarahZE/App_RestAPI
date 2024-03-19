package com.RESTAPI.AppList.mapper;

import com.RESTAPI.AppList.dto.ProductDto;
import com.RESTAPI.AppList.entity.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getColour(),
                productDto.getAmount(),
                productDto.getPrice()
        );

        return product;
    }

    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getColour(),
                product.getAmount(),
                product.getPrice()
        );

        return productDto;
    }
}
