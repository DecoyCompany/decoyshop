package com.decoyshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Auth_controller
{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Jwt_token_master jwtTokenMaster;

    @Autowired
    private Auth_service authService;

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        // Authenticate the user with email and password
        try
        {
            // Authenticate the user with email and password
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            // Generate JWT token if authentication is successful
            String token = jwtTokenMaster.generateToken(authentication);

            // Return the JWT token
            return ResponseEntity.ok(token);
        }

        catch (AuthenticationException e)
        {
            // If authentication fails, return a 401 Unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Authentication failed: Invalid email or password");
        }
    }
}
