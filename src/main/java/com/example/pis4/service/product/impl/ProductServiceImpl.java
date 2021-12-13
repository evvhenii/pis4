package com.example.pis4.service.product.impl;

import com.example.pis4.dto.ProductDto;
import com.example.pis4.entity.Cashier;
import com.example.pis4.entity.Product;
import com.example.pis4.entity.RoleEnum;
import com.example.pis4.exception.base.UnauthorizedException;
import com.example.pis4.repo.dao.ProductDao;
import com.example.pis4.repo.jpa.ProductRepo;
import com.example.pis4.service.product.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductDao productDao;

    @Override
    public List<Product> findAll(Cashier currentCashier) {
        if(currentCashier.getRole().getRoleEnum() != RoleEnum.ADMINISTRATOR) {
            throw new UnauthorizedException("You are not authorized");
        }
        return productDao.findAll();
    }

    @Override
    public void save(ProductDto dto, Cashier currentCashier) {
        if(currentCashier.getRole().getRoleEnum() != RoleEnum.ADMINISTRATOR) {
            throw new UnauthorizedException("You are not authorized");
        }

        productDao.save(
            Product.builder()
                    .code(UUID.randomUUID().toString())
                    .name(dto.getName())
                    .quantity(dto.getQuantity())
                    .price(dto.getPrice())
                    .build()
        );
    }
}
