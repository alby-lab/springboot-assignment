package com.agridence.microservice.Assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agridence.microservice.Assignment.config.JwtTokenUtil;
import com.agridence.microservice.Assignment.dto.AuthDto;
import com.agridence.microservice.Assignment.dto.UserDto;
import com.agridence.microservice.Assignment.services.JwtUserDetailsService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(userDto));
	}


	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthDto authenticationRequest) throws Exception {

		// authenticate(authenticationRequest.getUsername(),
		// authenticationRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(token);
		} else {
			return ResponseEntity.ok("invalid username/password");
			// throw new UsernameNotFoundException("invalid user request !");
		}
	}
	
}
