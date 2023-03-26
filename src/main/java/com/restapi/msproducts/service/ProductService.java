package com.restapi.msproducts.service;

import com.restapi.msproducts.model.Product;
import com.restapi.msproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService implements Iproduct{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product prd) {
        return productRepository.save(prd);
    }

    @Override
    public void delete(int id) {
    productRepository.deleteById(id);
    }
}
