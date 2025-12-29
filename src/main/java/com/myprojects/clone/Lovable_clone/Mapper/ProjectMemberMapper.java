package com.myprojects.clone.Lovable_clone.Mapper;

import com.myprojects.clone.Lovable_clone.DTOs.member.MemberResponse;
import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectResponse;
import com.myprojects.clone.Lovable_clone.Entity.Project;
import com.myprojects.clone.Lovable_clone.Entity.ProjectMember;
import com.myprojects.clone.Lovable_clone.Entity.User;
import com.myprojects.clone.Lovable_clone.Enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "role" ,  constant = "OWNER")
    MemberResponse toMemberResponseFromOwner (User owner);

    @Mapping(target = "userId" ,  source = "user.id")
    @Mapping(target = "email" ,  source = "user.email")
    @Mapping(target = "name" ,  source = "user.name")
    @Mapping(target = "role" ,  source = "projectRole")
    MemberResponse toMemberResponseFromMember (ProjectMember member);
}
