package com.AmanaCover.service;

import com.AmanaCover.dto.RegisterRequest;
import com.AmanaCover.entity.User;
import com.AmanaCover.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.AmanaCover.exception.UserAlreadyExistsException;
import com.AmanaCover.dto.LoginRequest;
import com.AmanaCover.dto.LoginResponse;
import com.AmanaCover.security.JwtService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(
            LoginRequest request
    ) {

        User user = userRepository
                .findByEmail(
                        request.getEmail()
                )
                .orElseThrow(
                        () -> new RuntimeException(
                                "Invalid credentials"
                        )
                );

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new RuntimeException(
                    "Invalid credentials"
            );
        }

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return new LoginResponse(token);
    }

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(request.getPassword())
                )
                .roles(Set.of("ROLE_CLIENT"))
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }
}