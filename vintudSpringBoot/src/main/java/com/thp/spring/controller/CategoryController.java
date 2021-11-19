package com.thp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.entity.Category;
import com.thp.spring.repository.CategoryRepository;
import com.thp.spring.service.CategoryService;
import com.thp.spring.serviceImpl.CategoryServiceImpl;




@RestController
@RequestMapping("/category")
public class CategoryController {

	
	
	
	public CategoryController() {
	}


	@Autowired
	CategoryRepository categoryRepository ;
	
	
	    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	    public void addAccount(@RequestBody Category category)   {
	        	        
		 categoryRepository.save(category) ;
	    }
	
	
	
	
	
	
	
	
	

/*
	public Category getCategoryById(int id) {
		
		Category category =  categoryRepository.getCategoryById(id) ;
		return category ;
		
	}
	
	public int getIdByName (String name) {
		
		return categoryRepository.getIdByName(name);
	}*/
}
