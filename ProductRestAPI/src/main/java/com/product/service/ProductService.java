package com.product.service;

import java.util.List;

import com.product.exception.ProductApplicationException;
import com.product.exception.ProductNotFoundException;
import com.product.model.Category;
import com.product.model.Product;

public interface ProductService {
	public List<Product> getProducts();
	public Product getProductById(Integer id)throws ProductNotFoundException;
	public Product saveProduct(Product product);
	public Product updateProduct(Product product)throws ProductNotFoundException;
	public Product deleteProduct(Product product)throws ProductNotFoundException;
	public List<Category> getCategory();
	public Category saveCategory(Category category);
	public Category updateCategory(Category  category)throws ProductApplicationException;
	public Category deleteCategory(Category category)throws ProductApplicationException;

}
