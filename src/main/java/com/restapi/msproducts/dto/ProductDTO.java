package com.restapi.msproducts.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class ProductDTO {
    @NotNull(message = "Name is required!")
    private String name;
    @NotNull
    @Positive(message = "Price cannot be Zero or negative")
    private double price;
}
