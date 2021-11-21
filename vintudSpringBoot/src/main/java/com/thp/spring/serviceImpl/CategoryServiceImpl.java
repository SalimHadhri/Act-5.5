package com.thp.spring.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
	public CategoryDto getCategoryById(Long id) {
		/* Optional<object.class>  : If a value is present, isPresent() returns true. 
		If no value is present, the object is considered empty and isPresent() returns false.
		ifPresent() (performs anaction if a value is present). 
		(==) : reference equality
		*/
		Optional<Category> categoryRendred =  categoryRepository.findById(id) ;
		CategoryDto categoryDtoRendred = modelMapperConverter.categoryEntityToDto(categoryRendred.get()) ;
		
		return categoryDtoRendred;
	}
	
	@Override
	public CategoryDto deleteCategroyById (Long id) {
		CategoryDto categoryDtoToDelete = this.getCategoryById(id);
		categoryRepository.deleteById(id); 
		return categoryDtoToDelete ;
	}

	
	@Override
	public CategoryDto updateById(Long id, CategoryDto newCategoryDto) throws Exception {	
		
		CategoryDto categoryDtoToDelete = getCategoryById(id) ;
		
		if(categoryDtoToDelete==null) {
			throw new Exception("no such category to update");		
			}
		newCategoryDto.setIdCategory(id);
		return addCategory(newCategoryDto) ;			
	}

	
	@Override
	public List<CategoryDto> getListCategory() {
		
		List<Category> listCategory = categoryRepository.findAll() ;
		
		List<CategoryDto> listCategoryDtos = new ArrayList<CategoryDto>() ;
		
		for(int i =0 ; i<listCategory.size();i++) {
			
			listCategoryDtos.add(modelMapperConverter.categoryEntityToDto(listCategory.get(i))) ;
			
		}
			
		return listCategoryDtos;
	}
	
	




	
	


}
