package com.ian.products_and_categories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ian.products_and_categories.models.Category;
import com.ian.products_and_categories.models.Product;
import com.ian.products_and_categories.repositories.ProductRepository;

@Service
public class ProductService 
{
	private ProductRepository pRepo;
	
	public ProductService(ProductRepository pRepo)
	{
		this.pRepo = pRepo;
	}
	
	public List<Product> allProducts()
	{
		return this.pRepo.findAll();
	}
	
	public Product findProductbyId(Long id)
	{
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product newProduct)
	{
		return this.pRepo.save(newProduct);
	}
	
	public List<Product> findProductsNotInCategory(Category category)
	{
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	public void addCategoryToProduct(Product product, Category category)
	{
		List<Category> categoryAlreadyInProduct = product.getCategories();
		categoryAlreadyInProduct.add(category);
		this.pRepo.save(product);
	}
}
