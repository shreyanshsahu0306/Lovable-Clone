package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.member.InviteMemberRequest;
import com.myprojects.clone.Lovable_clone.DTOs.member.MemberResponse;
import com.myprojects.clone.Lovable_clone.Entity.ProjectMember;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface ProjectMemberService {


    List<ProjectMember> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
