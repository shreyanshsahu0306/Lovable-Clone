package com.myprojects.clone.Lovable_clone.Controller;

import com.myprojects.clone.Lovable_clone.DTOs.auth.AuthResponse;
import com.myprojects.clone.Lovable_clone.DTOs.auth.LoginRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.SignupRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.UserProfileResponse;
import com.myprojects.clone.Lovable_clone.Service.AuthService;
import com.myprojects.clone.Lovable_clone.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(SignupRequest request){
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    public ResponseEntity<UserProfileResponse> me(){
        Long id = 1L;
        return ResponseEntity.ok(userService.getProfile(id));
    }
}
