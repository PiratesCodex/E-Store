package com.estore.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estore.app.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Optional<Product> findById(Long id);

}
