package com.thp.spring.service;





import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Category;



 public interface CategoryService {
	
	
	public CategoryDto addCategory (CategoryDto categoryDto) ;
	public  CategoryDto getCategoryById(Long id) ;
	public CategoryDto deleteCategroyById (Long id) ;
	public CategoryDto updateById(Long id, CategoryDto newCategoryDto) throws Exception ;	
	
	public void AfficherCategories () ;
	
	
	public int getIdByName (String name) ;
	
	

}
