package com.thp.spring.simplecontext.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.simplecontext.dto.CategoryDto;
import com.thp.spring.simplecontext.entity.Category;
import com.thp.spring.simplecontext.repository.CategoryRepository;
import com.thp.spring.simplecontext.service.CategoryService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {

		Category category = modelMapper.map(categoryDto, Category.class);
		Category categoryRendred = categoryRepository.save(category);
		CategoryDto categoryDtoRendred = modelMapper.map(categoryRendred, CategoryDto.class);

		return categoryDtoRendred;
	}

	@Override
	public CategoryDto getCategoryById(Long id) {

		Optional<Category> categoryRendred = categoryRepository.findById(id);
		CategoryDto categoryDtoRendred = modelMapper.map(categoryRendred.get(), CategoryDto.class);

		return categoryDtoRendred;
	}

	@Override
	public CategoryDto deleteCategroyById(Long id) {
		CategoryDto categoryDtoToDelete = this.getCategoryById(id);
		categoryRepository.deleteById(id);
		return categoryDtoToDelete;
	}

	@Override
	public CategoryDto updateById(Long id, CategoryDto newCategoryDto)  {


		newCategoryDto.setIdCategory(id);
		return addCategory(newCategoryDto);
	}

	@Override
	public List<CategoryDto> getListCategory() {

		List<Category> listCategory = categoryRepository.findAll();

		List<CategoryDto> listCategoryDtos = new ArrayList<CategoryDto>();

		for (int i = 0; i < listCategory.size(); i++) {

			listCategoryDtos.add(modelMapper.map(listCategory.get(i), CategoryDto.class));

		}

		return listCategoryDtos;
	}

}
