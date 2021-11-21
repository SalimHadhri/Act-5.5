package com.thp.spring.controller;

import org.modelmapper.ModelMapper; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Category;
import com.thp.spring.helper.ModelMapperConverter;
import com.thp.spring.service.CategoryService;



@RestController
@RequestMapping("/category")
public class CategoryController {

	
	
	
	public CategoryController() {
	}

	@Autowired
	private CategoryService categoryService ;
	
	
	

	
	@Autowired
	ModelMapperConverter modelMapperConverter ;
			
			
	@PostMapping(value = "/addCategory")
	public CategoryDto addCategory(@RequestBody CategoryDto categoryDto)   {	
		try {
			return categoryService.addCategory(categoryDto) ;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
					
	}
	
    @GetMapping(value = "/findCategory/{id}")
    public CategoryDto findCategoryById(@PathVariable Long id) {
    	try {
			return categoryService.getCategoryById(id) ;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }
    
    @DeleteMapping(value = "/deleteCategory/{id}")
    public CategoryDto deleteCategoryById(@PathVariable Long id) {
    	try {
			return categoryService.deleteCategroyById(id) ;
			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

    }
    
    @PutMapping(value = "/updateCategory/{id}")
    public CategoryDto updateCategoryById(@PathVariable Long id, @RequestBody CategoryDto newCategoryDto) {
    	try {
			return categoryService.updateById(id, newCategoryDto) ;
			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

    }
   
	
}
	
	//ResponseEntity<CategoryDto> 
	// new ResponseEntity<CategoryDto>(categoryDtoAdded, HttpStatus.CREATED);
	
