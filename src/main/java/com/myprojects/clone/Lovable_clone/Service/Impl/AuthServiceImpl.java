package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.auth.AuthResponse;
import com.myprojects.clone.Lovable_clone.DTOs.auth.LoginRequest;
import com.myprojects.clone.Lovable_clone.DTOs.auth.SignupRequest;
import com.myprojects.clone.Lovable_clone.Entity.User;
import com.myprojects.clone.Lovable_clone.Error.BadRequestException;
import com.myprojects.clone.Lovable_clone.Mapper.UserMapper;
import com.myprojects.clone.Lovable_clone.Repository.UserRepository;
import com.myprojects.clone.Lovable_clone.Security.AuthUtil;
import com.myprojects.clone.Lovable_clone.Service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;


    @Override
    public AuthResponse signUp(SignupRequest request) {
        userRepository.findByUsername(request.username())
                .ifPresent(user -> {throw new BadRequestException("User already exists with username: "+request.username());
        });
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        System.out.println("logged in");
        //if successfully authenticated then we will get the authentication object.
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }
}
