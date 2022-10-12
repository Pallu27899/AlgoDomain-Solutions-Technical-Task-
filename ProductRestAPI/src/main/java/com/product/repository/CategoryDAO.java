package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Category;
@Repository
public interface CategoryDAO extends JpaRepository<Category, String>{

}
