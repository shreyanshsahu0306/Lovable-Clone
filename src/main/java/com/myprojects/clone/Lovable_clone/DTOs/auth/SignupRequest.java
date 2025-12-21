package com.myprojects.clone.Lovable_clone.DTOs.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
