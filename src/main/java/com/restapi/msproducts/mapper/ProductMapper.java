package com.restapi.msproducts.mapper;

import com.restapi.msproducts.dto.ProductDTO;
import com.restapi.msproducts.model.Product;

public class ProductMapper {

    public static Product DtoToEntity(ProductDTO prd) {
        Product newPrd = new Product();
        newPrd.setName(prd.getName());
        newPrd.setPrice(prd.getPrice());
        return newPrd;
    }

    public static ProductDTO EntityToDto(Product prd) {
        ProductDTO newPrdDTO = new ProductDTO();
        newPrdDTO.setName(prd.getName());
        newPrdDTO.setPrice(prd.getPrice());
        return newPrdDTO;
    }
}
