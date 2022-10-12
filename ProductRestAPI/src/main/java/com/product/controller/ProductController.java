package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Category;
import com.product.model.Product;
import com.product.service.ProductService;
import com.product.service.ProductServiceImp;

@RestController
public class ProductController {
	@Autowired
	private ProductServiceImp productServiceImp;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductHandler(@PathVariable("id") Integer id){
		return new ResponseEntity<Product>(productServiceImp.getProductById(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductsHandler(){
		return new ResponseEntity<List<Product>>(productServiceImp.getProducts(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addProduct")
	public Product saveProductHandler(@RequestBody Product product) {
		return productServiceImp.saveProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProductHandler(@RequestBody Product product) {
		return productServiceImp.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct")
	public Product deleteProductHandler(@RequestBody Product product) {
		return productServiceImp.deleteProduct(product);
	}
	
	@GetMapping("/categorys")
	public ResponseEntity<List<Category>> getCategoryHandler(){
		return new ResponseEntity<List<Category>>(productServiceImp.getCategory(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addCategory")
	public Category saveCategoryHandler(@RequestBody Category category) {
		return productServiceImp.saveCategory(category);
	}
	
	@PutMapping("/updateCategory")
	public Category updateCategoryHandler(@RequestBody Category category) {
		return productServiceImp.updateCategory(category);
	}
	
	@DeleteMapping("deleteCategory")
	public Category deleteCategoryHandler(@RequestBody Category category) {
		return productServiceImp.deleteCategory(category);
	}


}
