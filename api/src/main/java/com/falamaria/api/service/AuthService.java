package com.falamaria.api.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falamaria.api.dto.LoginRequest;
import com.falamaria.api.dto.LoginResponse;
import com.falamaria.api.security.TokenService;

@Service
@Transactional(readOnly = true)
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthService(AuthenticationManager authenticationManager,
                       TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public LoginResponse logar(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getSenha()
            )
        );

        String token = tokenService.gerarToken(request.getUsername());
        return new LoginResponse(true, token, "Login realizado com sucesso");
    }
}