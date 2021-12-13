package com.example.pis4.repo.jpa;

import com.example.pis4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByCode(String s);
}
