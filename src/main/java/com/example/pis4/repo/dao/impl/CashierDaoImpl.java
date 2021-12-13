package com.example.pis4.repo.dao.impl;

import com.example.pis4.entity.Cashier;
import com.example.pis4.repo.dao.CashierDao;
import com.example.pis4.repo.dao.ProductDao;
import com.example.pis4.repo.jpa.CashierRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CashierDaoImpl implements CashierDao {
    CashierRepo cashierRepo;

    @Override
    public Optional<Cashier> findCashierByIdAndPassword(Long id, String password) {
        return cashierRepo.findCashierByIdAndPassword(id, password);
    }
}
