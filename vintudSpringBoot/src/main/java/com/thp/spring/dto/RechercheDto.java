package com.thp.spring.dto;


public class RechercheDto {

	
	


	private Long idRecherche ;
    
    




	private String type_habit ;
	private String taille ;
	private String couleur ;
	private float fourchette_prix ;
	
	
	public RechercheDto() {
	}


	
	
	public RechercheDto(Long id, String type_habit, String taille, String couleur, float fourchette_prix) {
		this.idRecherche = id;
		this.type_habit = type_habit;
		this.taille = taille;
		this.couleur = couleur;
		this.fourchette_prix = fourchette_prix;
	}


	public Long getId() {
		return idRecherche;
	}


	public void setId(Long id) {
		this.idRecherche = id;
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




	public Long getIdRecherche() {
		return idRecherche;
	}




	public void setIdRecherche(Long idRecherche) {
		this.idRecherche = idRecherche;
	}




	@Override
	public String toString() {
		return "RechercheDto [idRecherche=" + idRecherche + ", type_habit=" + type_habit + ", taille=" + taille
				+ ", couleur=" + couleur + ", fourchette_prix=" + fourchette_prix + "]";
	}



	
	
	
}
