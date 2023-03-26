package com.restapi.msproducts.controller;

import com.restapi.msproducts.dto.ProductDTO;
import com.restapi.msproducts.excepion.ProductNotFoundException;
import com.restapi.msproducts.mapper.ProductMapper;
import com.restapi.msproducts.model.Product;
import com.restapi.msproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable @Min(1) Integer id) {
        Product prd = productService.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No Product with ID : " + id));
        return ResponseEntity.ok().body(prd);
    }

    @PostMapping(value = "/products")
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO inprod) {
        Product prd = ProductMapper.DtoToEntity(inprod);
        Product addedPrd = productService.save(prd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedPrd.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping(value="/products/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable("id")  @Min(1) int id, @Valid @RequestBody ProductDTO inprod) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));

        Product newPrd = ProductMapper.DtoToEntity(inprod);
        newPrd.setId(prd.getId());
        productService.save(newPrd);
        return ResponseEntity.ok().body(newPrd);
    }
    @DeleteMapping(value="/products/{id}")
    ResponseEntity deleteProduct( @PathVariable("id") @Min(1) int id) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        productService.delete(prd.getId());
        return ResponseEntity.ok().body("Product with ID : "+id+" deleted with success!");
    }

}
