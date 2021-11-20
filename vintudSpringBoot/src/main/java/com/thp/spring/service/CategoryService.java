package com.thp.spring.service;





import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Category;



 public interface CategoryService {
	
	
	public CategoryDto addCategory (CategoryDto categoryDto) ;
	
	public void AfficherCategories () ;
	
	public  Category getCategoryById(int id) ;
	
	public int getIdByName (String name) ;
	
	

}
