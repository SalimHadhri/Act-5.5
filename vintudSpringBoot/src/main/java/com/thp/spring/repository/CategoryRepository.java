package com.thp.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.entity.Category;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CategoryRepository extends JpaRepository<Category,Long> {

	

	
	
}


