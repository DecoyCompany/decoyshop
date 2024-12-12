package com.decoyshop.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class Jwt_filter extends OncePerRequestFilter
{

    @Autowired
    private Jwt_token_master jwtTokenMaster;

    private String getTokenFromRequest(HttpServletRequest request) {
        // Extract the token from the Authorization header
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);  // Remove "Bearer " prefix
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Get the JWT from the request header
        String token = getTokenFromRequest(request);

        // If a token is present and valid, authenticate the user
        if (token != null && jwtTokenMaster.validateToken(token)) {
            // Get authentication from token
            Authentication authentication = jwtTokenMaster.getAuthentication(token);

            // Set the authentication in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }

}
