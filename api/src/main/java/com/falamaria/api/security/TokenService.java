package com.falamaria.api.security;

public interface TokenService {

    String gerarToken(String username);
    boolean validarToken(String token);
    String getSubject(String token);


}
