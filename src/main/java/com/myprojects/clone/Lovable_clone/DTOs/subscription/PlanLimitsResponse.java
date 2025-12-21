package com.myprojects.clone.Lovable_clone.DTOs.subscription;

public record PlanLimitsResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
