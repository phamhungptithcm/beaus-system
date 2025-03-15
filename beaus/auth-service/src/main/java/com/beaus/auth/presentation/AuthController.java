package com.beaus.auth.presentation;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beaus.auth.application.service.IAuthService;
import com.beaus.auth.model.ApiResponse;
import com.beaus.auth.model.JwtAuthenticationResponse;
import com.beaus.auth.model.LoginRequest;
import com.beaus.auth.model.RegisterRequest;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
	private final IAuthService authService;

    // Constructor injection ensures a cleaner dependency model
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtAuthenticationResponse response = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
        ApiResponse response = authService.registerUser(signUpRequest);
        HttpStatus status = true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }
}

