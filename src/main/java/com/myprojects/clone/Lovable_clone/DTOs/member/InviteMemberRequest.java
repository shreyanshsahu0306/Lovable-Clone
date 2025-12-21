package com.myprojects.clone.Lovable_clone.DTOs.member;
import com.myprojects.clone.Lovable_clone.Enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
