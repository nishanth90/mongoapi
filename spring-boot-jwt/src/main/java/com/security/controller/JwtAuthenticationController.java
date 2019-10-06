package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.config.JwtTokenUtil;
import com.security.model.JwtRequest;
import com.security.model.JwtResponse;
import com.security.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		String pwd = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		if(pwd != null) {
			System.out.println(pwd);
			final String token = jwtTokenUtil.generateToken(authenticationRequest);
			return ResponseEntity.ok(new JwtResponse(token));

		} else {
			return ResponseEntity.badRequest().build();
		}

	}
}
