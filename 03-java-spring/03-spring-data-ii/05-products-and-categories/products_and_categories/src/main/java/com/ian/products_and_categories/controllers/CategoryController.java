package com.ian.products_and_categories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ian.products_and_categories.models.Category;
import com.ian.products_and_categories.models.Product;
import com.ian.products_and_categories.services.CategoryService;
import com.ian.products_and_categories.services.ProductService;

@Controller
public class CategoryController 
{
	private CategoryService cService;
	private ProductService pService;

	public CategoryController(CategoryService cService, ProductService pService)
	{
		this.cService = cService;
		this.pService = pService;
	}
	
	@GetMapping("/category/new")
	public String newCategory()
	{
		return "newCategory.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@RequestParam("name") String categoryName)
	{
		Category newCategory = new Category();
		newCategory.setName(categoryName);
		this.cService.createCategory(newCategory);
		return "redirect:/category/new";
	}
	
	@GetMapping("/category/{id}")
	public String showCategory(
			@PathVariable("id") Long id,
			Model model)
	{
		Category category = this.cService.findCategorybyId(id);
		model.addAttribute("notInCategory", this.pService.findProductsNotInCategory(category));
		model.addAttribute("category", category);
		return "showCategory.jsp";
	}
	
	@PostMapping("/category/addProduct/{id}")
	public String addProduct(
			@PathVariable("id") Long id,
			@RequestParam("products") Long productId)
	{
		Category categoryToAddProduct = this.cService.findCategorybyId(id);
		Product productToAdd = this.pService.findProductbyId(productId);
		this.cService.addProductToCategory(categoryToAddProduct, productToAdd);
		return "redirect:/category/{id}";
	}

}
