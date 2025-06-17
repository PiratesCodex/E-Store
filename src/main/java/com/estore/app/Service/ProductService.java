package com.estore.app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estore.app.Model.Product;

@Service
public interface ProductService {

public Iterable<Product> getAllProduct();

public Product saveOneProduct(Product product);

public <optional>Product getProductById(Integer id);

public Product updateProduct(Integer id, Product product);

public void deleteProduct(Integer id);

public List<Product> saveMultipleProducts(List<Product> products);

public List<Product> saveAllProducts(List<Product> products);

}
