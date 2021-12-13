package com.example.pis4.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class ProductDto {
    String name;
    Integer quantity;
    Integer price;
}
