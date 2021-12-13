package com.example.pis4.service.product;

import com.example.pis4.dto.ProductDto;
import com.example.pis4.entity.Cashier;
import com.example.pis4.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(Cashier currentCashier);

    void save(ProductDto productDto, Cashier currentCashier);
}
