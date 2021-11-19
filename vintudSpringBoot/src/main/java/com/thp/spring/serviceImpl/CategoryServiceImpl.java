package com.thp.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.entity.Category;
import com.thp.spring.repository.CategoryRepository;
import com.thp.spring.service.CategoryService;



@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository ;
	
	
	
	@Override
	public void addCategory(Category category) {

		categoryRepository.addCategory(category);
		
		
		
		
	}
	
	
	@Override
	public void AfficherCategories() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIdByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	


}
