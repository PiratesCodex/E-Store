package com.estore.app.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estore.app.Config.JwtUtil;
import com.estore.app.Model.User;
import com.estore.app.Service.UserService;

@RestController
@ControllerAdvice
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/genarateToken")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
	    User user = userService.loginUser(username, password);
	    String token = jwtUtil.generateToken(username);
	    Map<String, Object> response = new HashMap<>();
	    response.put("token", token);
	    response.put("user", user);
	    return ResponseEntity.ok(response);
	}
}
