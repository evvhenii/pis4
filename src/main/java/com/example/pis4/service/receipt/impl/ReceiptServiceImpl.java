package com.example.pis4.service.receipt.impl;

import com.example.pis4.entity.Cashier;
import com.example.pis4.entity.Product;
import com.example.pis4.entity.Receipt;
import com.example.pis4.entity.ReceiptEntry;
import com.example.pis4.repo.ProductRepo;
import com.example.pis4.repo.ReceiptRepo;
import com.example.pis4.service.receipt.ReceiptService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptServiceImpl implements ReceiptService {
    ReceiptRepo receiptRepo;
    ProductRepo productRepo;

    @Override
    public void save(String[] codes, Integer[] quantities, Cashier currentCashier) {
        List<ReceiptEntry> receiptEntryList = new ArrayList<>();
        for (int i = 0; i < codes.length; i++) {
            Product product = productRepo.findByCode(codes[i]);
            Integer quantity = quantities[i];

            receiptEntryList.add(
                    ReceiptEntry.builder()
                            .product(product)
                            .quantity(quantity)
                            .sum((long) product.getPrice() * quantity)
                            .build()
            );
        }

        Receipt receipt = Receipt.builder()
                .cashier(currentCashier)
                .dateTime(new Date(Calendar.getInstance().getTime().getTime()))
                .receiptEntries(receiptEntryList)
                .totalPrice(receiptEntryList.stream()
                        .map(ReceiptEntry::getSum)
                        .reduce(0L, Long::sum)
                )
                .build();
        receiptEntryList.stream().forEach(a -> a.setReceipt(receipt));

        receiptRepo.save(receipt);
    }
}
