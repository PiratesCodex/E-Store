package com.estore.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.estore.app.Exception.InvalidCredentialsException;
import com.estore.app.Exception.UserAlreadyExistsException;
import com.estore.app.Exception.UserNotFoundException;
import com.estore.app.Model.User;
import com.estore.app.Repository.UserRepository;
import com.estore.app.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User loginUser(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user == null || passwordEncoder.matches(password, user.getUsername())) {
			throw new InvalidCredentialsException("Invalid username or password");
		}
//				if(!password.equals(user.getPassword()))
//				{
//					throw new InvalidCredentialsException("Invalid username or password");
//				}

		return user;
	}

	@Override
	public User saveUser(User user) {
		if (userRepository.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistsException("User with username: " + user.getUsername() + " already exists.");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("No users found");
		}
		return users;

	}

	@Override
	public List<User> getListByCity(String city) {
		List<User> userslist = userRepository.findByCity(city);
		if (userslist.isEmpty()) {
			throw new UserNotFoundException("No users found in city: " + city);
		}

		return userslist;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UserNotFoundException("User with username: " + username + " not found.");
		}

		return user;
	}

}
