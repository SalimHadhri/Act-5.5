package com.thp.spring.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.entity.Announcement;
import com.thp.spring.entity.Category;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {

	

	
	
}
