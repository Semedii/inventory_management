package com.example.inventory_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.example.inventory_management.model.AuthenticationRequest;
import com.example.inventory_management.model.AuthenticationResponse;
import com.example.inventory_management.config.JwtUtils;
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            System.out.println("hahafhehbhb =============== 00000-----");
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

            // Generate JWT token
            String token = jwtUtils.generateToken(userDetails);

            // Return token
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (Exception e) {
            System.out.println("Authentication failed for user: " + request.getUsername());
            e.printStackTrace(); // Log the error for debugging
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
