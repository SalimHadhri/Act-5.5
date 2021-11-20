package com.thp.spring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void addCategory(@RequestBody Category category)   {	

		
		CategoryDto categoryDto = modelMapperConverter.categoryEntityToDto(category)	 ;	
		categoryService.addCategory(categoryDto) ;
		
		//public ResponseEntity<CategoryDto> addCategory(@RequestBody Category category)   {
		//return new ResponseEntity<CategoryDto>(catregoryAdded, HttpStatus.CREATED);

		
	}
	
	

}


//try {
//}
//  catch (Exception e) {
  //    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
  //}
