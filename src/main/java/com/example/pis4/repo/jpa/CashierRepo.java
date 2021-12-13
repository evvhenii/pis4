package com.example.pis4.repo.jpa;

import com.example.pis4.entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CashierRepo extends JpaRepository<Cashier, Long> {
    Optional<Cashier> findCashierByIdAndPassword(Long id, String password);
}
