package com.restapi.msproducts.service;

import com.restapi.msproducts.model.Product;

import java.util.List;
import java.util.Optional;

public interface Iproduct {
    List<Product> getAllProducts();
    Optional<Product> findById(int id);
    Product save(Product prd);
    void delete(int id);
}
