package com.thp.spring.simplecontext.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Favoris")
public class Favoris implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFavoris;

	private String dateAjout;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne
	private User userFavori;

	@OneToOne
	private Announcement annonceFavori;

	public Favoris() {
	}

	public Long getId_favoris() {
		return idFavoris;
	}

	public void setId_favoris(Long id_favoris) {
		this.idFavoris = id_favoris;
	}

	public String getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Favoris(Long id_favoris, String dateAjout) {
		this.idFavoris = id_favoris;
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
		return "Favoris [id_favoris=" + idFavoris + ", dateAjout=" + dateAjout + ", userFavori=" + userFavori
				+ ", annonceFavori=" + annonceFavori + "]";
	}

}
