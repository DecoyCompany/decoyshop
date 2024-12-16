package com.decoyshop.security;

import com.decoyshop.entities.Kullanici;
import com.decoyshop.repositories.Kullanici_repo;
import com.decoyshop.services.CRUD_service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class Jwt_token_master
{
    private static final Logger logger = LoggerFactory.getLogger(Jwt_token_master.class);

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration-time}")
    private long EXPIRATION_TIME;

    @Autowired
    private Auth_service authService;

    // Method to generate the JWT token
    public String generateToken(Authentication authentication)
    {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())//its actually user email, we send it through username
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS512.getJcaName()))
                .compact();
    }

    // Method to validate the JWT token
    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parserBuilder()  // Updated method for parsing JWT
                    .setSigningKey(SECRET_KEY.getBytes()) // Use SecretKey for parsing
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (JwtException | IllegalArgumentException e)
        {
            logger.error("Invalid or expired JWT token: {}", e.getMessage());
            return false;
        }
    }

    // Method to extract the authentication info (user details) from the token
    public Authentication getAuthentication(String token) {

        Claims claims = getClaimsFromToken(token);
        String email = claims.getSubject();

        UserDetails userDetails = authService.loadUserByUsername(email);

        return new UsernamePasswordAuthenticationToken(userDetails, "",
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    // Method to extract claims from the JWT
    private Claims getClaimsFromToken(String token) {

        return Jwts.parserBuilder()  // Updated method for parsing JWT
                .setSigningKey(SECRET_KEY.getBytes()) // Use SecretKey for parsing
                .build()
                .parseClaimsJws(token) // Parse the JWT token
                .getBody();
    }
}
