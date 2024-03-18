package com.RESTAPI.AppList.repository;

import com.RESTAPI.AppList.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
