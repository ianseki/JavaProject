package com.ian.products_and_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ian.products_and_categories.models.Category;
import com.ian.products_and_categories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{
	List<Product> findAll();
	
	// Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);
    // Retrieves a list of any products a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
}

