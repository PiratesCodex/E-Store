package com.estore.app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estore.app.Model.User;

@Service
public interface UserService {

public User loginUser(String username, String password);

public User saveUser(User user);

public List<User> getAllUser();

public List<User> getListByCity(String city);

public User getUserByUsername(String username);

}
