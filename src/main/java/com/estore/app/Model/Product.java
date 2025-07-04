package com.estore.app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "productid")
	private Integer productId;

	@Column(name = "productname")
	private String productName;

	@Column(name = "productdescription")
	private String productDescription;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "amount")
	private String amount;

	@Column(name = "product_status")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product(Integer id, Integer productId, String productName, String productDescription, String quantity,
			String amount, String status) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.amount = amount;
		this.status = status;
	}

	public Product() {
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", quantity=" + quantity + ", amount=" + amount
				+ ", status=" + status + "]";
	}

}
