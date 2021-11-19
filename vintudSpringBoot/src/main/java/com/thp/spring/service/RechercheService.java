package com.thp.spring.service;

import com.thp.spring.entity.Recherche;

public interface RechercheService {

	
	
	
	public Recherche chooseRechercheSpecifications ();
	public void creerRecherche () ;
	public void afficherRecherches() ;
	public void supprimerRecherche () ;
	public Recherche findResearchByIdUser (int id_user) ;
	public void lancerRecherche(String email, String pwd) ;
	public void modifyRecherche() ;
	
	
	
	
}
