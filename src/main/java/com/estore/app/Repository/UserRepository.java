package com.estore.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estore.app.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	List<User> findByCity(String city);

}
