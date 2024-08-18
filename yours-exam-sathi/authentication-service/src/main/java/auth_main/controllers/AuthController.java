package auth_main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth_main.dtos.LoginRequest;
import auth_main.dtos.SignupRequest;
import auth_main.services.UserServices;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserServices userService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Validated @RequestBody SignupRequest signupRequest){
		try {
	        userService.registerNewUser(signupRequest);
	        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}
	
	// login already handled by spring security customauthentication filters.
	
//	@PostMapping("/login")
//	public ResponseEntity<?> loginUser(@Validated @RequestBody LoginRequest loginRequest){
////		userService.loginUser(loginRequest);
//		return null;
//	}
	
	
}
