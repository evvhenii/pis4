package com.example.pis4.controller;

import com.example.pis4.dto.ReceiptEntryDto;
import com.example.pis4.entity.Cashier;
import com.example.pis4.entity.RoleEnum;
import com.example.pis4.service.receipt.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Controller
@RequestMapping("receipts")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ReceiptController {
    ReceiptService receiptService;

    @GetMapping
    public String getAll(HttpSession session) {
        Cashier currentCashier = (Cashier) session.getAttribute("user");

        if(currentCashier.getRole().getRoleEnum() == RoleEnum.CASHIER) {
            return "receipt-creating";
        }

        return "login-not-authorized";
    }

    @PostMapping
    //TODO probably it's possible to make it better and easier
    public String post(String[] code, Integer[] quantity, HttpSession session) {
        Cashier currentCashier = (Cashier) session.getAttribute("user");

        receiptService.save(code, quantity, currentCashier);

        return "redirect:/receipts";
    }
}
