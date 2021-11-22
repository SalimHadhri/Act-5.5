package com.thp.spring.dto;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.ManyToOne;

import com.thp.spring.entity.Category;
import com.thp.spring.entity.User;




@DataSourceDefinition(className = "Announcement", name = "AnnouncementDto")
public class AnnouncementDto {
	

	
	
	private Long idAnnouncement ;
	
	private String title  ;
	
	private String description  ;
	
		
	private int price ;
	
	private String picture;
	
	private String publication_date; 
	
	private boolean is_available  ;
	
	private int view_number  ;
	
	private String localisation  ;
	
    private User userAnnouncement ;
	
	
    private Category categoryAnnonce ;

	


	public AnnouncementDto() {
	}





	public User getUserAnnouncement() {
		return userAnnouncement;
	}





	public void setUserAnnouncement(User userAnnouncement) {
		this.userAnnouncement = userAnnouncement;
	}





	public Category getCategoryAnnonce() {
		return categoryAnnonce;
	}





	public void setCategoryAnnonce(Category categoryAnnonce) {
		this.categoryAnnonce = categoryAnnonce;
	}





	public Long getIdAnnouncement() {
		return idAnnouncement;
	}



	public void setIdAnnouncement(Long idAnnouncement) {
		this.idAnnouncement = idAnnouncement;
	}










	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getPublication_date() {
		return publication_date;
	}


	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}


	public boolean isIs_available() {
		return is_available;
	}





	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}







	public int getView_number() {
		return view_number;
	}


	public void setView_number(int view_number) {
		this.view_number = view_number;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}





	@Override
	public String toString() {
		return "AnnouncementDto [idAnnouncement=" + idAnnouncement + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", picture=" + picture + ", publication_date=" + publication_date
				+ ", is_available=" + is_available + ", view_number=" + view_number + ", localisation=" + localisation
				+ "]";
	}





	
	
	
	
}
