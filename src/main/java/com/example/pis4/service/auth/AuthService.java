package com.example.pis4.service.auth;

import com.example.pis4.dto.LoginDto;
import com.example.pis4.entity.Cashier;

public interface AuthService {
    Cashier get(LoginDto loginDto);
}
