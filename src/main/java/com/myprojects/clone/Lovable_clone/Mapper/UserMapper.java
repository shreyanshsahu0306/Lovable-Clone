package com.myprojects.clone.Lovable_clone.Mapper;

import com.myprojects.clone.Lovable_clone.DTOs.auth.SignupRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.UserProfileResponse;
import com.myprojects.clone.Lovable_clone.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
