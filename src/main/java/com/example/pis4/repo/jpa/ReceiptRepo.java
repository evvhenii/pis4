package com.example.pis4.repo.jpa;

import com.example.pis4.entity.Cashier;
import com.example.pis4.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ReceiptRepo extends JpaRepository<Receipt, Long> {
}
