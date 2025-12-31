package com.myprojects.clone.Lovable_clone.DTOs.member;

import com.myprojects.clone.Lovable_clone.Enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
