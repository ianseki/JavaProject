package com.ian.products_and_categories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ian.products_and_categories.models.Category;
import com.ian.products_and_categories.models.Product;
import com.ian.products_and_categories.services.CategoryService;
import com.ian.products_and_categories.services.ProductService;

@Controller
public class ProductController 
{
	private ProductService pService;
	private CategoryService cService;
	
	public ProductController(ProductService pService, CategoryService cService)
	{
		this.pService = pService;
		this.cService = cService;
	}
	
	@GetMapping("/product/new")
	public String newProduct()
	{
		return "newProduct.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(
			@RequestParam("name") String productName,
			@RequestParam("description") String description,
			@RequestParam("price") float price,
			Model model)
	{
		Product newProduct = new Product(productName, description, price);
		this.pService.createProduct(newProduct);
		return "redirect:/product/new";
	}
	
	@GetMapping("/product/{id}")
	public String showProduct(
			@PathVariable("id") Long id,
			Model model)
	{
		Product product = this.pService.findProductbyId(id);
		model.addAttribute("notInProduct", this.cService.findCategoriesNotInProduct(product));
		model.addAttribute("product", product);
		return "showProduct.jsp";
	}
	
	@PostMapping("/product/addCategory/{id}")
	public String addCategory(
			@PathVariable("id") Long id,
			@RequestParam("categories") Long categoryId)
	{
		Product productToAddCategory = this.pService.findProductbyId(id);
		Category categoryToAdd = this.cService.findCategorybyId(categoryId);
		this.pService.addCategoryToProduct(productToAddCategory, categoryToAdd);
		return "redirect:/product/{id}";
	}
}
