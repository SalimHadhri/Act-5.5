package com.thp.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.thp.spring.dto.AnnouncementDto;
import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Announcement;
import com.thp.spring.repository.AnnouncementRepository;
import com.thp.spring.service.AnnouncementService;




@RestController
@RequestMapping("/announcementManagement")
public class AnnouncementController {

	
	
    @Autowired
	AnnouncementService announcementService ;
	
	
    
    

	
	@PostMapping(value = "/addAnnouncement")
	public AnnouncementDto addCategory(@RequestBody AnnouncementDto announcementDto)   {	
		try {
			
			AnnouncementDto announcementDto2 = announcementService.addAnnouncement(announcementDto) ;
			
			return announcementDto2;
			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
					
	}
	
    @GetMapping(value = "/ListAnnouncement") 
    public List<AnnouncementDto> findAllAnnouncement() {
    	try {
    		
    		List<AnnouncementDto> announcementDtosToView= announcementService.consulterAnnonces() ;
    		
			return  announcementDtosToView;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }
	
    
    @GetMapping(value = "/findAnnouncement/{id}")
    public AnnouncementDto findAnnouncementById(@PathVariable Long id) {
    	try {
			return announcementService.findAnnounceById(id);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }
    
    
	@DeleteMapping(value = "deleteAnnouncement/{id}")
	public AnnouncementDto delete(@PathVariable Long id) {
		try {
			return announcementService.deleteAnnouncementById(id) ;
		
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
    @PutMapping(value = "updateAnnouncement/{id}")
    public AnnouncementDto updateAnnouncementById(@PathVariable Long id , @RequestBody AnnouncementDto announcementDto) {
    	try {
    		
    		
			return  announcementService.updateById(id, announcementDto) ;

			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

    }
    

    


	
	

}
