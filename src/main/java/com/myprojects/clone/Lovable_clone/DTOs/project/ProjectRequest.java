package com.myprojects.clone.Lovable_clone.DTOs.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank String name
) {
}
