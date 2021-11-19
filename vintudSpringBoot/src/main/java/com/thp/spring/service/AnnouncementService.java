package com.thp.spring.service;

import java.util.ArrayList;

import com.thp.spring.entity.Announcement;

public interface AnnouncementService {
	
	public void consulterAnnonces ()  ;
	public void findAnnouncementByNameCatgeryAndOrPrice () ;		
	public void filtreAnnoucementPrix () ;
	public void filtreAnnoucementLocalisation () ;
	public void voirNombreVues (String email, String pwd) ;
	
	public ArrayList<Announcement> findAnnounceByIdUser(int id);
	public Announcement findAnnounceById (int id) ;	
	
	public ArrayList<Announcement> findAllAnnoucement();
	public int addAnnouncement(Announcement announcement) ;

}
