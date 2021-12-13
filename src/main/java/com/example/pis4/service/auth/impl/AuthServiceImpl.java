package com.example.pis4.service.auth.impl;

import com.example.pis4.dto.LoginDto;
import com.example.pis4.entity.Cashier;
import com.example.pis4.exception.base.NotFoundException;
import com.example.pis4.repo.dao.CashierDao;
import com.example.pis4.repo.jpa.CashierRepo;
import com.example.pis4.service.auth.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {
    CashierDao cashierDao;

    @Override
    public Cashier get(LoginDto loginDto) {
        return cashierDao.findCashierByIdAndPassword(
                loginDto.getUsername(),
                        loginDto.getPassword()
                )
                .orElseThrow(() -> new NotFoundException("User does not exist"));
    }
}
