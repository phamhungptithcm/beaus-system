package com.beaus.auth.application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beaus.auth.application.gateway.IAuthService;
import com.beaus.auth.model.ApiResponse;
import com.beaus.auth.model.JwtAuthenticationResponse;
import com.beaus.auth.model.LoginRequest;
import com.beaus.auth.model.RegisterRequest;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService implements IAuthService, UserDetailsService {
//	private final AuthenticationManager authenticationManager;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final IJwtService tokenProvider;
//
//    public AuthServiceImpl(AuthenticationManager authenticationManager,
//                           UserRepository userRepository,
//                           RoleRepository roleRepository,
//                           PasswordEncoder passwordEncoder,
//                           IJwtService tokenProvider) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.tokenProvider = tokenProvider;
//    }

    @Override
    public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
		return null;
//        Authentication authentication = authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                loginRequest.getUsernameOrEmail(),
//                loginRequest.getPassword()
//            )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.generateToken(authentication);
//        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public ApiResponse registerUser(RegisterRequest signUpRequest) {
		return null;
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return new ApiResponse(false, "Username is already taken!");
//        }
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ApiResponse(false, "Email Address already in use!");
//        }
//
//        // Creating user's account
//        User user = new User();
//        user.setUsername(signUpRequest.getUsername());
//        user.setEmail(signUpRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
//
//        // Assign default role. Make sure the role "USER" exists in your DB.
//        roleRepository.findByName("USER").ifPresentOrElse(
//            role -> user.getRoles().add(role),
//            () -> { throw new AppException("User Role not set."); }
//        );
//
//        userRepository.save(user);
//        return new ApiResponse(true, "User registered successfully");
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
  
}