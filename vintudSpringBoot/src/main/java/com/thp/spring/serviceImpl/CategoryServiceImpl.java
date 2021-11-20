package com.thp.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Category;
import com.thp.spring.helper.ModelMapperConverter;
import com.thp.spring.repository.CategoryRepository;
import com.thp.spring.service.CategoryService;



@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryRepository categoryRepository ;
	


	@Autowired
	private ModelMapperConverter modelMapperConverter ;
	
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		
		Category category = modelMapperConverter.categoryDtoToEntity(categoryDto) ;
		Category categoryRendred =  categoryRepository.save(category) ;
		CategoryDto categoryDtoRendred = modelMapperConverter.categoryEntityToDto(categoryRendred) ;
		
		return categoryDtoRendred ;

		
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
