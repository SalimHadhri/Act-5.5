package com.thp.spring.dto;

import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(className = "Category", name = "CategoryDto")
public class CategoryDto {

	
	




	private Long idCategory ;
    
    
	private String name  ;
	private String description  ;

    
    
	
	public CategoryDto() {
	}

	public Long getId_category() {
		return idCategory;
	}

	
	
	
	


	public void setId_category(Long id_category) {
		this.idCategory = id_category;
	}

	public CategoryDto(Long id_category, String name, String description) {
		this.idCategory = id_category;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CategoryDto [idCategory=" + idCategory + ", name=" + name + ", description=" + description + "]";
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	
	
	
}
