package com.example.pis4.controller;

import com.example.pis4.dto.ProductDto;
import com.example.pis4.entity.Cashier;
import com.example.pis4.entity.Product;
import com.example.pis4.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Controller
@RequestMapping("products")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping
    public String getAll(HttpSession session, Model model) {
        Cashier currentCashier = (Cashier) session.getAttribute("user");

        List<Product> allProducts = productService.findAll(currentCashier);
        model.addAttribute("productRecords", allProducts);
        return "product-records";
    }

    @PostMapping
    public String post(ProductDto productDto, HttpSession session) {
        Cashier currentCashier = (Cashier) session.getAttribute("user");

        productService.save(productDto, currentCashier);

        return "redirect:/products";
    }
}
