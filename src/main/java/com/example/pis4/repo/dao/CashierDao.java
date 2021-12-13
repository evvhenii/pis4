package com.example.pis4.repo.dao;

import com.example.pis4.entity.Cashier;

import java.util.Optional;

public interface CashierDao {
    Optional<Cashier> findCashierByIdAndPassword(Long id, String password);
}
