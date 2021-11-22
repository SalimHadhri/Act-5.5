package com.thp.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Category;
import com.thp.spring.helper.ModelMapperConverter;
import com.thp.spring.service.CategoryService;


@RestController  // ======> json
//@Controller   ======> jsp
@RequestMapping("/categoryManagement")
public class CategoryController {

	
	
	
	public CategoryController() {
	}

	@Autowired
	private CategoryService categoryService ;
	
	@Autowired
	ModelMapperConverter modelMapperConverter ;

/********************************************************************************************************************************/
    @RequestMapping({"/", "/welcomePage"})
    public String home(Model model) {
        model.addAttribute("message", "Gestion Categoriiiiies");
        return "welcomePage";
    }
    
    /*************************************************************************************************************************************/
    @GetMapping(value = "/ListCategory") 
    public String findAllCatgory(Model model) {
    	try {
    		
    		List<CategoryDto> categoryDtosToView= categoryService.getListCategory() ;
    		
            model.addAttribute("listCategoriiiies", categoryDtosToView);
			return  "ListCategory";
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }

    
    /********************************************************************************************************************************/
    
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		try {
		categoryService.deleteCategroyById(id) ;
		
		return "redirect:/categoryManagement/ListCategory";
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
	/*******************************************************************************************************************************/
	
  /*  @PutMapping(value = "/updateCategory/{id}")
    public CategoryDto updateCategoryById(@PathVariable Long id, @RequestBody CategoryDto newCategoryDto) {
    	try {
			return categoryService.updateById(id, newCategoryDto) ;
			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

    }*/
    
    @GetMapping(value = "updateCategory/{id}/{name}/{description}")
    public String updateCategoryById(@PathVariable("id") Long id ,String name, String description ) {
    	try {
    		
    		CategoryDto categoryDto = new CategoryDto(id, name, description) ;
			 categoryService.updateById(id, categoryDto) ;
			return "redirect:/categoryManagement/ListCategory";

			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

    }
    
	
	
	
	
	
	/*******************************************************************************************************/
	/*
	@PostMapping(value = "/addCategory")
	public CategoryDto addCategory(@RequestBody CategoryDto categoryDto)   {	
		try {
			CategoryDto categoryDtoAdded = categoryService.addCategory(categoryDto)  ;
			return categoryDtoAdded;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
					
	}
	*/
	
	
	@PostMapping(value = "/addCategory")
	public CategoryDto addCategory(@RequestBody CategoryDto categoryDto)   {	
		try {
			CategoryDto categoryDtoAdded = categoryService.addCategory(categoryDto)  ;
			return categoryDtoAdded;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
					
	}
	
/***********************************************************************************************************/	
	
	
	
	
	
    


  
			
			

	
    @GetMapping(value = "/findCategory/{id}")
    public CategoryDto findCategoryById(@PathVariable Long id) {
    	try {
			return categoryService.getCategoryById(id) ;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }
    

    

    				

   
	
}
	
	//ResponseEntity<CategoryDto> 
	// new ResponseEntity<CategoryDto>(categoryDtoAdded, HttpStatus.CREATED);
	
