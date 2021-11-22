package com.thp.spring.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.dto.AnnouncementDto;
import com.thp.spring.dto.CategoryDto;
import com.thp.spring.entity.Announcement;
import com.thp.spring.entity.Category;
import com.thp.spring.helper.ModelMapperConverter;
import com.thp.spring.repository.AnnouncementRepository;
import com.thp.spring.repository.CategoryRepository;
import com.thp.spring.service.AnnouncementService;




@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AnnouncementServiceImpl    implements AnnouncementService {

	
	
	@Autowired
	AnnouncementRepository announcementRepository ;
	


	@Autowired
	private ModelMapperConverter modelMapperConverter ;
	
	@Override
	public AnnouncementDto addAnnouncement(AnnouncementDto announcementDto) {
		
		
		Announcement announcement =  modelMapperConverter.announcementDtoToEntity(announcementDto) ;
		Announcement announcement2 = announcementRepository.save(announcement);
		
		AnnouncementDto announcementDto2 = modelMapperConverter.announcementEntityToDto(announcement2);
		
		return announcementDto2 ;
	}

	
	
		
	
	@Override
	public List<AnnouncementDto>  consulterAnnonces ()  {
		
		
		
		List<Announcement> listAnnouncement = announcementRepository.findAll() ;
		
		List<AnnouncementDto> listAnnouncementDtos = new ArrayList<AnnouncementDto>() ;
		
		for(int i =0 ; i<listAnnouncement.size();i++) {
			
			listAnnouncementDtos.add(modelMapperConverter.announcementEntityToDto(listAnnouncement.get(i))) ;
			
		}
			
		return listAnnouncementDtos;
	}

	
	
	@Override
	public AnnouncementDto findAnnounceById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Announcement> announcementRendred =  announcementRepository.findById(id) ;
		AnnouncementDto AnnouncementDtoRendred = modelMapperConverter.announcementEntityToDto(announcementRendred.get()) ;
		
		return AnnouncementDtoRendred ;
		
	}

	
	


	@Override
	public AnnouncementDto deleteAnnouncementById(Long id) {
		
		AnnouncementDto AnnouncementDtoToDelete = this.findAnnounceById(id);
		announcementRepository.deleteById(id); 
		return AnnouncementDtoToDelete ;
	
	}
	
	
	
	@Override
	public AnnouncementDto updateById(Long id, AnnouncementDto newAnnouncementDto) throws Exception {

		
		AnnouncementDto announcementDtoToDelete = findAnnounceById(id) ;
		
		if(announcementDtoToDelete==null) {
			throw new Exception("no such category to update");		
			}
		newAnnouncementDto.setIdAnnouncement(id);
		return addAnnouncement(newAnnouncementDto) ;
		
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
	public ArrayList<Announcement> findAllAnnoucement() {
		// TODO Auto-generated method stub
		return null;
	}










}
