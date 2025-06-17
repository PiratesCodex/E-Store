package com.estore.app.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.app.Exception.ProductIsAlreadyPresentException;
import com.estore.app.Exception.ProductNotFoundException;
import com.estore.app.Model.Product;
import com.estore.app.Repository.ProductRepository;
import com.estore.app.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProduct() {
		List<Product> products = productRepository.findAll();
		if (products.isEmpty()) {
			throw new ProductNotFoundException("No Product Fount");
		}
		return products;
	}

	@Override
	public Product saveOneProduct(Product product) {
		validateProduct(product);

		if (product.getProductId() != null && productRepository.existsById(product.getProductId())) {
			throw new ProductIsAlreadyPresentException(
					"Product with ID " + product.getProductId() + " is already present.");

		}
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> saveAllProducts(List<Product> products) {
	    for (Product product : products) {
	        validateProduct(product);

	        if (product.getProductId() != null && productRepository.existsById(product.getProductId())) {
	            throw new ProductIsAlreadyPresentException(
	                "Product with ID " + product.getProductId() + " is already present."
	            );
	        }
	    }

	    return productRepository.saveAll(products);
	}


	@Override
	public <optional> Product getProductById(Integer id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found."));
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product existingProduct = productRepository.findById(id)
	            .orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found."));

	   
	    existingProduct.setProductName(product.getProductName());
	    existingProduct.setQuantity(product.getQuantity());
	    existingProduct.setAmount(product.getAmount());

	    return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found.")) ;
		
		productRepository.delete(product);
	}

	@Override
	public List<Product> saveMultipleProducts(List<Product> products) {
		 for (Product product : products) {
		        validateProduct(product);
		        
		        Optional<Product> existingProduct = productRepository.findById(product.getProductId());
		        
		        if (existingProduct.isPresent()) {
		            Product existing = existingProduct.get();
		            existing.setQuantity(existing.getQuantity() + product.getQuantity());
		            productRepository.save(existing); // Update quantity
		        } else {
		            productRepository.save(product); // Save as a new product
		        }
		    }
		    return productRepository.findAll();
	}
	
	public void validateProduct(Product product)
	{
		if(product.getProductName()==null || product.getProductName().isEmpty())
		{
			throw new IllegalArgumentException("Product name cannot be empty.");
		}
		
		if (product.getQuantity() == null || product.getQuantity().isEmpty()) 
		{ 
	        throw new IllegalArgumentException("Product quantity must be greater than zero.");
	    }
		if (product.getAmount() == null || product.getAmount().isEmpty()) {
	        throw new IllegalArgumentException("Product amount cannot be empty.");
	    }
	}

}
