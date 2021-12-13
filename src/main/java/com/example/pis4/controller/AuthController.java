package com.example.pis4.controller;

import com.example.pis4.dto.LoginDto;
import com.example.pis4.entity.Cashier;
import com.example.pis4.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static lombok.AccessLevel.PRIVATE;

@Controller
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @GetMapping
    public String get() {
        return "login";
    }

    @PostMapping
    public String post(LoginDto loginDto, HttpSession session) {
        Cashier cashier = authService.get(loginDto);
        session.setAttribute("user", cashier);

        switch (cashier.getRole().getRoleEnum()) {
            case CASHIER:
                return "redirect:/receipts";
            case ADMINISTRATOR:
                return "redirect:/products";
        }
        System.out.println("--------------");
        System.out.println(cashier);
        System.out.println("----------------");

        session.setAttribute("df", "ccervr");

        return "login-with-error";
    }
}
