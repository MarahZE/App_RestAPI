package com.RESTAPI.AppList.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDto {

    private Long id;
    private String name;
    private String colour;
    private double amount;
    private double price;
}
