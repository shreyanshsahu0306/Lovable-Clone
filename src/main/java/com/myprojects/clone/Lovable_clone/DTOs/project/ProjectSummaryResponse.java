package com.myprojects.clone.Lovable_clone.DTOs.project;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
