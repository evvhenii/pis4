package com.example.pis4.repo;

import com.example.pis4.entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashierRepo extends JpaRepository<Cashier, Long> {
    Optional<Cashier> findCashierByIdAndPassword(Long id, String password);
}
