package com.myprojects.clone.Lovable_clone.DTOs.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
