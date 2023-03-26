package com.restapi.msproducts.repository;

import com.restapi.msproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
