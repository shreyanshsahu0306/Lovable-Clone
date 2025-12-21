package com.myprojects.clone.Lovable_clone.DTOs.project;

import com.myprojects.clone.Lovable_clone.DTOs.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
