package com.thp.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.thp.spring.entity.Announcement;
import com.thp.spring.repository.AnnouncementRepository;

public class AnnouncementController {

	
	
    @Autowired
	AnnouncementRepository announcementRepository ;
	
	
	/*
	public AnnouncementController() {
	}

	public ArrayList<Announcement> getAnnoncesByUtilisateurId(int utilisateurId) {		
		return announcementRepository.findAnnounceByIdUser(utilisateurId) ;	
	}
	
	public Announcement getAnnoncesById(int annonceId) {		
		return announcementRepository.findAnnounceById(annonceId);	
	}
	
	public ArrayList<Announcement> getAllAnnonces() {		
		return announcementRepository.findAllAnnoucement();	
	}
	
	public int addAnnouncement(Announcement announcement) {
		
		return announcementRepository.addAnnouncement(announcement);

	}
	*/
	

}
