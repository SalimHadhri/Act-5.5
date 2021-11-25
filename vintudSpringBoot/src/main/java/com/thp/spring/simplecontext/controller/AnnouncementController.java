package com.thp.spring.simplecontext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.simplecontext.dto.AnnouncementDto;
import com.thp.spring.simplecontext.service.AnnouncementService;

@RestController
@RequestMapping("/announcementManagement")
public class AnnouncementController {

	@Autowired
	public AnnouncementService announcementService;

	@PostMapping(value = "/addAnnouncement")
	public AnnouncementDto addAnnouncement(@RequestBody AnnouncementDto announcementDto) {

		return announcementService.addAnnouncement(announcementDto);

	}

	@GetMapping(value = "/ListAnnouncement")
	public List<AnnouncementDto> findAllAnnouncement() {

		List<AnnouncementDto> announcementDtosToView = announcementService.consulterAnnonces();

		return announcementDtosToView;

	}

	@GetMapping(value = "/findAnnouncement/{id}")
	public AnnouncementDto findAnnouncementById(@PathVariable Long id) {
		return announcementService.findAnnounceById(id);

	}

	@DeleteMapping(value = "/deleteAnnouncement/{id}")
	public AnnouncementDto delete(@PathVariable Long id) {
		return announcementService.deleteAnnouncementById(id);

	}

	@PutMapping(value = "/updateAnnouncement/{id}")
	public AnnouncementDto updateAnnouncementById(@PathVariable Long id, @RequestBody AnnouncementDto announcementDto) 
			{

		return announcementService.updateById(id, announcementDto);

	}

}
