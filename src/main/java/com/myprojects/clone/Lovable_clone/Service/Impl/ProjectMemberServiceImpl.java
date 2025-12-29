package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.member.InviteMemberRequest;
import com.myprojects.clone.Lovable_clone.DTOs.member.MemberResponse;
import com.myprojects.clone.Lovable_clone.DTOs.member.UpdateMemberRoleRequest;
import com.myprojects.clone.Lovable_clone.Entity.Project;
import com.myprojects.clone.Lovable_clone.Entity.ProjectMember;
import com.myprojects.clone.Lovable_clone.Entity.ProjectMemberId;
import com.myprojects.clone.Lovable_clone.Entity.User;
import com.myprojects.clone.Lovable_clone.Mapper.ProjectMemberMapper;
import com.myprojects.clone.Lovable_clone.Repository.ProjectMemberRepository;
import com.myprojects.clone.Lovable_clone.Repository.ProjectRepository;
import com.myprojects.clone.Lovable_clone.Repository.UserRepository;
import com.myprojects.clone.Lovable_clone.Service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProject(projectId, userId);
        List<MemberResponse> memberResponseList = new ArrayList<>();
        //adding owner to list
        memberResponseList.add(projectMemberMapper.toMemberResponseFromOwner(project.getOwner()));
        //adding other members to the list
        memberResponseList.addAll(projectMemberRepository.findByIdProjectId(projectId).stream().map(projectMember -> projectMemberMapper.toMemberResponseFromMember(projectMember)).toList());
        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProject(projectId, userId);
        //checking if this user is the owner of project or not
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("You are not allowed to invite.");
        }
        //checking if user is inviting itself
        User invitee = userRepository.findByEmail(request.email()).orElseThrow();
        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("You cannot invite yourself");
        }
        //checking if invitee is already a part of the project
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member is already a part of the project.");
        }
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProject(projectId, userId);
        //checking if this user is the owner of project or not
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("You are not allowed to update role.");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProject(projectId, userId);
        //checking if this user is the owner of project or not
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("You are not allowed to delete.");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member not found.");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }

    /*Helper method*/
    public Project getAccessibleProject(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
