package com.example.pis4.service.receipt;

import com.example.pis4.entity.Cashier;

public interface ReceiptService {
    void save(String[] code, Integer[] quantity, Cashier currentCashier);
}
