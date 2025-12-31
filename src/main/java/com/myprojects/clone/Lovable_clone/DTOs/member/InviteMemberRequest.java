package com.myprojects.clone.Lovable_clone.DTOs.member;
import com.myprojects.clone.Lovable_clone.Enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotBlank String email,
        @NotNull ProjectRole role
) {
}
