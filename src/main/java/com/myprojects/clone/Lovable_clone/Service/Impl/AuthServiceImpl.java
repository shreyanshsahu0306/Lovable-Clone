package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.auth.AuthResponse;
import com.myprojects.clone.Lovable_clone.DTOs.auth.LoginRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.SignupRequest;
import com.myprojects.clone.Lovable_clone.Entity.User;
import com.myprojects.clone.Lovable_clone.Error.BadRequestException;
import com.myprojects.clone.Lovable_clone.Mapper.UserMapper;
import com.myprojects.clone.Lovable_clone.Repository.UserRepository;
import com.myprojects.clone.Lovable_clone.Service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signUp(SignupRequest request) {
        userRepository.findByUsername(request.username())
                .ifPresent(user -> {throw new BadRequestException("User already exists with username: "+request.username());
        });
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        return new AuthResponse("bearerxyzdummytoken", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
