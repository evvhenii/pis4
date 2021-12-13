package com.example.pis4.repo.dao.impl;

import com.example.pis4.entity.Receipt;
import com.example.pis4.repo.dao.ReceiptDao;
import com.example.pis4.repo.jpa.ReceiptRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptDaoImpl implements ReceiptDao {
    ReceiptRepo receiptRepo;
    @Override
    public void save(Receipt receipt) {
        receiptRepo.save(receipt);
    }
}
