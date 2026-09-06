package com.falamaria.api.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

     private final TokenService tokenService;
    private final AuthorizationService authorizationSevice;

    public JwtFilter(TokenService tokenService, AuthorizationService authorizationSevice) {
        this.tokenService = tokenService;
        this.authorizationSevice = authorizationSevice;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
           final String header = request.getHeader("Authorization");
           final String prefix = "Bearer";

           if (header != null && header.startsWith(prefix)) {
                String token = header.substring(7);
                
                if (tokenService.validarToken(token)) {
                    String email = tokenService.getSubject(token);
                    UserDetails userDetails = authorizationSevice.loadUserByUsername(email);

                    var auth = new UsernamePasswordAuthenticationToken( 
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
                    SecurityContextHolder.getContext().setAuthentication(auth); 
           }
    }
        filterChain.doFilter(request, response);
    
    }
    
}
