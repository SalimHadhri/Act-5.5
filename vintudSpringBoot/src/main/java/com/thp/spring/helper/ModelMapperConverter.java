package com.thp.spring.helper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Category;

@Configuration
public class ModelMapperConverter{
	
	
	@Bean
	public ModelMapper ModelMapperConverter () {
		return new ModelMapper() ;
	};
	
    @Autowired
	private ModelMapper modelMapper ;

	
	// convert DTO category to entity category
	
	public Category categoryDtoToEntity(CategoryDto categoryDto) {	
		return modelMapper.map(categoryDto,Category.class) ;
	}
	
	// convert category entity to dto category
	
	public CategoryDto categoryEntityToDto(Category category) {	
		return modelMapper.map(category,CategoryDto.class) ;
	}

	
	
}


