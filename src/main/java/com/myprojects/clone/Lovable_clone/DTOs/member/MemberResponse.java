package com.myprojects.clone.Lovable_clone.DTOs.member;

import com.myprojects.clone.Lovable_clone.Enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
