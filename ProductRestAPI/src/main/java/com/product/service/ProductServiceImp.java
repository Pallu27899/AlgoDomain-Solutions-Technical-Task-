package com.product.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.ProductApplicationException;
import com.product.exception.ProductNotFoundException;
import com.product.model.Category;
import com.product.model.Product;
import com.product.repository.CategoryDAO;
import com.product.repository.ProductDAO;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product>list=productDAO.findAll();
		for(Product p:list){
			Optional<Category> opt=categoryDAO.findById(p.getProductCategory());
			Category value=opt.get();
			double price=p.getProductPrice();
			double discount=value.getDiscount()*(price/100);
			double gst=value.getGST()*(price/100);
			p.setProductPrice(price+gst-discount+value.getDeliveryCharge());
			
		}
		
		return list;
	}
	
	@Override
	public Product getProductById(Integer id) throws ProductNotFoundException {
		// TODO Auto-generated method stu
		Optional<Product> opt=productDAO.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ProductNotFoundException("Product Not Exits!");
		}
		
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		return productDAO.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> opt=productDAO.findById(product.getProduct_id());
		if(opt.isPresent()) {
			return productDAO.save(product);
		}else {
			throw new ProductNotFoundException("Product Not Exits!");
		}
		
	}

	@Override
	public Product deleteProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> opt=productDAO.findById(product.getProduct_id());
		if(opt.isPresent()) {
			
		productDAO.deleteById(product.getProduct_id());
		return product;
		}else {
			throw new ProductNotFoundException("Product Not Exits!");
		}
		
	}

	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		Optional<Category> opt =categoryDAO.findById(category.getProductCategory());
		if(opt.isPresent()) {
			
			return categoryDAO.save(category);
		}else {
			throw new ProductApplicationException("Category Not Exits!");
		}
		
	}

	@Override
	public Category deleteCategory(Category category) {
		Optional<Category> opt =categoryDAO.findById(category.getProductCategory());
		if(opt.isPresent()) {
			categoryDAO.deleteById(category.getProductCategory());
			return category;
		}else {
			throw new ProductApplicationException("Category Not Exits!");
		}
	}

	

}
