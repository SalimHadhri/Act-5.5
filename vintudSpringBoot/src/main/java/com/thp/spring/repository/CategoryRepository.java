package com.thp.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thp.spring.entity.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	
	
	void addCategory (Category category) ;

	
	
}


