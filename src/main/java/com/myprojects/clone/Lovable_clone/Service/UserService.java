package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {

    UserProfileResponse getProfile(Long id);
}
