package com.falamaria.api.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService implements TokenService {

    @Value("${api.security.token.secret}")
    private String chaveSecreta;

    private Key obterChave() {
        return Keys.hmacShaKeyFor(chaveSecreta.getBytes(StandardCharsets.UTF_8));
    }

    private final long expiration = 86400000; // 24h

    @Override
    public String gerarToken(String username) {
        Date agora = new Date();
        Date expiracao = new Date(agora.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(agora)
                .setExpiration(expiracao)
                .signWith(obterChave(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(obterChave()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {

            return false;
        }
    }

    @Override
    public String getSubject(String token) { 
        Claims claims = Jwts.parserBuilder().setSigningKey(obterChave()).build().parseClaimsJws(token).getBody();
            return claims.getSubject();
    }

}
