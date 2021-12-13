package com.example.pis4.repo.dao;

import com.example.pis4.entity.Product;

import java.util.List;

public interface ProductDao {
    Product findByCode(String s);

    List<Product> findAll();

    void save(Product build);
}
