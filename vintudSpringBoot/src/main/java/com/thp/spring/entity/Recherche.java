package com.thp.spring.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Recherche")
public class Recherche implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
    
    
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private String type_habit ;
	private String taille ;
	private String couleur ;
	private float fourchette_prix ;
	
	
	public Recherche() {
	}


	
    @ManyToOne
    private User userRecherche ;
	
	
	public Recherche(int id, String type_habit, String taille, String couleur, float fourchette_prix) {
		this.id = id;
		this.type_habit = type_habit;
		this.taille = taille;
		this.couleur = couleur;
		this.fourchette_prix = fourchette_prix;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType_habit() {
		return type_habit;
	}


	public void setType_habit(String type_habit) {
		this.type_habit = type_habit;
	}


	public String getTaille() {
		return taille;
	}


	public void setTaille(String taille) {
		this.taille = taille;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public float getFourchette_prix() {
		return fourchette_prix;
	}


	public void setFourchette_prix(float fourchette_prix) {
		this.fourchette_prix = fourchette_prix;
	}


	public User getUserRecherche() {
		return userRecherche;
	}


	public void setUserRecherche(User userRecherche) {
		this.userRecherche = userRecherche;
	}


	@Override
	public String toString() {
		return "Recherche [id=" + id + ", type_habit=" + type_habit + ", taille=" + taille + ", couleur=" + couleur
				+ ", fourchette_prix=" + fourchette_prix + ", userRecherche=" + userRecherche + "]";
	}



	
	
	
	

}
