package com.RESTAPI.AppList.controller;

import com.RESTAPI.AppList.dto.ProductDto;
import com.RESTAPI.AppList.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //add product REST API
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }

    //get all products REST API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.getAllProducts();
        return ResponseEntity.ok(productDtoList);
    }

    //get product by ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductByID(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.ok(productDto);
    }

    //add amount REST API
    @PutMapping("/{id}/addAmount")
    public ResponseEntity<ProductDto> addAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        ProductDto productDto = productService.addAmount(id, amount);
        return ResponseEntity.ok(productDto);
    }

    //reduce amount REST API
    @PutMapping("/{id}/reduceAmount")
    public ResponseEntity<ProductDto> reduceAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        ProductDto productDto = productService.reduceAmount(id, amount);
        return ResponseEntity.ok(productDto);
    }

    //change prise REST API
    @PutMapping("/{id}/changePrise")
    public ResponseEntity<ProductDto> changePrise(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double prise = request.get("prise");
        ProductDto productDto = productService.changePrise(id, prise);
        return ResponseEntity.ok(productDto);
    }

    //get products by property REST API
    @GetMapping ("/{property}/getProductsByPro")
    public ResponseEntity<List<ProductDto>> getProductsByProperty(@PathVariable String property, @RequestBody Map<String, String> request) {
        String value = request.get("value");
        List<ProductDto> productDtoList = productService.getProductsByProperty(property , value);
        return ResponseEntity.ok(productDtoList);
    }

    //delete product REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
       productService.deleteProduct(id);
       return ResponseEntity.ok("Product is deleted successfully!");
    }
}
