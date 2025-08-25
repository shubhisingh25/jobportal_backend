package com.jobPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Correct import for PasswordEncoder
import org.springframework.stereotype.Service;

import com.jobPortal.DTO.LoginRequestDTO;
import com.jobPortal.DTO.RegisterRequestDTO;
import com.jobPortal.Entity.User;
import com.jobPortal.Repository.UserRepository;
import com.jobPortal.Security.JWTUtil;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder; // Correct type for PasswordEncoder
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	public String register(RegisterRequestDTO dto) {
		
		// Check if user already exists by name or email
		// Assuming UserRepository has methods like existsByUsername and existsByEmail
		if(userRepository.existsByName(dto.getName()) || userRepository.existsByEmail(dto.getEmail())) {
		    throw new RuntimeException("User already exists");
		}
	
	    User user = new User();
	    
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    // Encode the password before saving
	    user.setPassword(passwordEncoder.encode(dto.getPassword())); 
	    user.setRole(dto.getRole());
	    
	    userRepository.save(user);
	    
	    return "User registered successfully"; // Corrected spelling
	    
	 }
	
	public String login(LoginRequestDTO dto) {
		// Find user by email, assuming findByEmail method exists
		User user = userRepository.findByEmail(dto.getEmail())
		                           .orElseThrow(() -> new RuntimeException("User not found"));
		
		// Match the provided password with the stored encoded password
		if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid credentials"); // Corrected spelling
		}
		
		// Generate JWT token for the authenticated user
		return jwtUtil.generateToken(user);
	}
}
