package com.beaus.auth.application.gateway;

import com.beaus.auth.model.ApiResponse;
import com.beaus.auth.model.JwtAuthenticationResponse;
import com.beaus.auth.model.LoginRequest;
import com.beaus.auth.model.RegisterRequest;

public interface IAuthService {
	JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest);
    ApiResponse registerUser(RegisterRequest signUpRequest);
}
