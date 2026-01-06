package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.auth.UserProfileResponse;
import com.myprojects.clone.Lovable_clone.Error.ResourceNotFoundException;
import com.myprojects.clone.Lovable_clone.Repository.UserRepository;
import com.myprojects.clone.Lovable_clone.Service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService, UserDetailsService {
    UserRepository userRepository;

    @Override
    public UserProfileResponse getProfile(Long id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Username", username));

    }
}
