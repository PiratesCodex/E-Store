package com.estore.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.app.Model.User;
import com.estore.app.Repository.UserRepository;
import com.estore.app.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User loginUser(String username, String password) {
		return userRepository.findByUsername(username)
				.filter(user -> user.getPassword().equals(password))
				.orElseThrow(() ->new RuntimeException("Invalid username or password"));
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getListByCity(String city) {
		return userRepository.findByCity(city);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}

}
