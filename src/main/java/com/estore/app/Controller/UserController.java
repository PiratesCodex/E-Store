package com.estore.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.app.Model.User;
import com.estore.app.Service.UserService;
import com.estore.app.Util.ResponseStructure;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestBody LoginRequest loginRequest) {
	    ResponseStructure<User> response = new ResponseStructure<>();

	    String username = loginRequest.getUsername();
	    String password = loginRequest.getPassword();

	    User user = userService.loginUser(username, password);
	    response.setStatus(HttpStatus.OK.value());
	    response.setMessage("Login successful");
	    response.setData(user);
	    
	    return ResponseEntity.ok(response);
	}


	@PostMapping("/addUser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		ResponseStructure<User> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("User Registered Successfully...");
		response.setData(saveUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
	    List<User> users = userService.getAllUser(); // Assumes userService returns an empty list if none found

	    ResponseStructure<List<User>> response = new ResponseStructure<>();
	    response.setStatus(HttpStatus.OK.value());
	    response.setMessage(users.isEmpty() ? "No users found" : "Users retrieved successfully");
	    response.setData(users);

	    return ResponseEntity.ok(response);
	}

	@GetMapping("/city/{city}")
	public ResponseEntity<ResponseStructure<List<User>>> getListByCity(@PathVariable String city) {
	    List<User> listCity = userService.getListByCity(city);
	    ResponseStructure<List<User>> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Users in " + city + " retrieved successfully");
        response.setData(listCity);
	    return ResponseEntity.ok(response);
	}

	@GetMapping("{username}")
	public ResponseEntity<ResponseStructure<User>> getUserByUsername(@PathVariable String username) {
		User saveUsername = userService.getUserByUsername(username);
		ResponseStructure<User> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("User retrieved successfully");
        response.setData(saveUsername);
		return ResponseEntity.ok(response);
	}

}
