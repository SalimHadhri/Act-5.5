package com.thp.spring.entity;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Favoris")
public class Favoris implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id_favoris ;
    
    
	private String dateAjout ;
	
	
	
    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@ManyToOne
    private User userFavori ;
	
	
    @OneToOne
    private Announcement annonceFavori ;
	

    
	public Favoris() {
	}
	

	public int getId_favoris() {
		return id_favoris;
	}


	public void setId_favoris(int id_favoris) {
		this.id_favoris = id_favoris;
	}






	public String getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Favoris(int id_favoris , String dateAjout) {
		this.id_favoris = id_favoris;
		this.dateAjout = dateAjout;
	}


	public User getUserFavori() {
		return userFavori;
	}


	public void setUserFavori(User userFavori) {
		this.userFavori = userFavori;
	}


	public Announcement getAnnonceFavori() {
		return annonceFavori;
	}


	public void setAnnonceFavori(Announcement annonceFavori) {
		this.annonceFavori = annonceFavori;
	}


	@Override
	public String toString() {
		return "Favoris [id_favoris=" + id_favoris + ", dateAjout=" + dateAjout + ", userFavori=" + userFavori
				+ ", annonceFavori=" + annonceFavori + "]";
	}








	
	
	
	
	
	
	
	
	
	
	
	

}
