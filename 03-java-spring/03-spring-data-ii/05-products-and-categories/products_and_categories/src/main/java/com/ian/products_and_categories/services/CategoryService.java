package com.ian.products_and_categories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ian.products_and_categories.models.Category;
import com.ian.products_and_categories.models.Product;
import com.ian.products_and_categories.repositories.CategoryRepository;

@Service
public class CategoryService 
{
	private CategoryRepository cRepo;
	
	public CategoryService(CategoryRepository cRepo)
	{
		this.cRepo = cRepo;
	}
	
	public List<Category> allCategories()
	{
		return this.cRepo.findAll();
	}
	
	public Category findCategorybyId(Long id)
	{
		return this.cRepo.findById(id).orElse(null);
	}
	
	public Category createCategory(Category newCategory)
	{
		return this.cRepo.save(newCategory);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product)
	{
		return this.cRepo.findByProductsNotContains(product);
	}
	
	public void addProductToCategory(Category category, Product product)
	{
		List<Product> productAlreadyInCategory = category.getProducts();
		productAlreadyInCategory.add(product);
		this.cRepo.save(category);
	}
}
