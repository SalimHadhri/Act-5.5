package com.thp.spring.serviceImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.thp.spring.entity.Announcement;
import com.thp.spring.service.AnnouncementService;




@Service
public class AnnouncementServiceImpl    implements AnnouncementService {

	@Override
	public void consulterAnnonces() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAnnouncementByNameCatgeryAndOrPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filtreAnnoucementPrix() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filtreAnnoucementLocalisation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voirNombreVues(String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Announcement> findAnnounceByIdUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Announcement findAnnounceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Announcement> findAllAnnoucement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAnnouncement(Announcement announcement) {
		// TODO Auto-generated method stub
		return 0;
	}

}
