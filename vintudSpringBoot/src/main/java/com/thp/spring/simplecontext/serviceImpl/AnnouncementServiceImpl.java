package com.thp.spring.simplecontext.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.simplecontext.dto.AnnouncementDto;
import com.thp.spring.simplecontext.entity.Announcement;
import com.thp.spring.simplecontext.repository.AnnouncementRepository;
import com.thp.spring.simplecontext.service.AnnouncementService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	AnnouncementRepository announcementRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public AnnouncementDto addAnnouncement(AnnouncementDto announcementDto) {

		Announcement announcement = modelMapper.map(announcementDto, Announcement.class);
		Announcement announcement2 = announcementRepository.save(announcement);

		AnnouncementDto announcementDto2 = modelMapper.map(announcement2, AnnouncementDto.class);
		return announcementDto2;
	}

	@Override
	public List<AnnouncementDto> consulterAnnonces() {

		List<Announcement> listAnnouncement = announcementRepository.findAll();

		List<AnnouncementDto> listAnnouncementDtos = new ArrayList<AnnouncementDto>();

		for (int i = 0; i < listAnnouncement.size(); i++) {

			listAnnouncementDtos.add(modelMapper.map(listAnnouncement.get(i), AnnouncementDto.class));

		}

		return listAnnouncementDtos;
	}

	@Override
	public AnnouncementDto findAnnounceById(Long id) {
		// TODO Auto-generated method stub

		Optional<Announcement> announcementRendred = announcementRepository.findById(id);
		AnnouncementDto AnnouncementDtoRendred = modelMapper.map(announcementRendred.get(), AnnouncementDto.class);

		return AnnouncementDtoRendred;

	}

	@Override
	public AnnouncementDto deleteAnnouncementById(Long id) {

		AnnouncementDto AnnouncementDtoToDelete = this.findAnnounceById(id);
		announcementRepository.deleteById(id);
		return AnnouncementDtoToDelete;

	}

	@Override
	public AnnouncementDto updateById(Long id, AnnouncementDto newAnnouncementDto)  {


	
		newAnnouncementDto.setIdAnnouncement(id);
		
		Announcement announcement = modelMapper.map(newAnnouncementDto,Announcement.class) ;
		Announcement announcement2 = announcementRepository.save(announcement) ;
		AnnouncementDto announcementDto = modelMapper.map(announcement2, AnnouncementDto.class) ;
		return announcementDto ;

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
