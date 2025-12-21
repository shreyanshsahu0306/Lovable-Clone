package com.myprojects.clone.Lovable_clone.DTOs.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
