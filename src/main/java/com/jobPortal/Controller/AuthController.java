package com.jobPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.DTO.LoginRequestDTO;
import com.jobPortal.DTO.RegisterRequestDTO;
import com.jobPortal.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	@Autowired
	private AuthService authService;
	

	@PostMapping("/register")
	public ResponseEntity<String>register(@RequestBody RegisterRequestDTO dto){
		return ResponseEntity.ok(authService.register(dto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String>login(@RequestBody LoginRequestDTO dto){
		return ResponseEntity.ok(authService.login(dto));
	}
}
