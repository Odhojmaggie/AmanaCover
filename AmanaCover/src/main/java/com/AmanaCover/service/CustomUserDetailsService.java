package com.AmanaCover.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.AmanaCover.entity.User;
import com.AmanaCover.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String email
    ) throws UsernameNotFoundException {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"
                        ));

        return org.springframework.security.core.userdetails
                .User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(
                        user.getRoles()
                                .stream()
                                .map(SimpleGrantedAuthority::new)
                                .toList()
                )

                .build();
    }
}