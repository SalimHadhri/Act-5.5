package com.thp.spring.service;

import com.thp.spring.entity.Category;

public interface CategoryService {
	
	
	public void addCategory (Category category) ;
	
	
	
	
	public void AfficherCategories () ;
	
	public  Category getCategoryById(int id) ;
	
	public int getIdByName (String name) ;
	
	

}
