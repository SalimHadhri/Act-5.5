package com.thp.spring.simplecontext.service;

import java.util.List;

import com.thp.spring.simplecontext.dto.CategoryDto;

public interface CategoryService {

	public CategoryDto addCategory(CategoryDto categoryDto);

	public CategoryDto getCategoryById(Long id);

	public CategoryDto deleteCategroyById(Long id);

	public CategoryDto updateById(Long id, CategoryDto newCategoryDto) ;

	public List<CategoryDto> getListCategory();

}
