package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.auth.AuthResponse;
import com.myprojects.clone.Lovable_clone.DTOs.auth.LoginRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.SignupRequest;
import com.myprojects.clone.Lovable_clone.Service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    @Override
    public AuthResponse signUp(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
