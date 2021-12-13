package com.example.pis4.repo.dao.impl;

import com.example.pis4.entity.Product;
import com.example.pis4.repo.dao.CashierDao;
import com.example.pis4.repo.dao.ProductDao;
import com.example.pis4.repo.jpa.ProductRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductDaoImpl implements ProductDao {
    ProductRepo productRepo;

    public Product findByCode(String s) {
        return productRepo.findByCode(s);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }
}
