package com.example.biblioteca.controller;

import com.example.biblioteca.dto.*;
import com.example.biblioteca.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );
        String token = jwtService.gerarToken(dto.getUsername());
        return new LoginResponseDTO(token);
    }
}
