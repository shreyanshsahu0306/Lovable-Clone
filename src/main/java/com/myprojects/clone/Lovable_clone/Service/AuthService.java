package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.auth.AuthResponse;
import com.myprojects.clone.Lovable_clone.DTOs.auth.LoginRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    AuthResponse signUp(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
