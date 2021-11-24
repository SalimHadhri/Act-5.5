package com.thp.spring.simplecontext.service;

import java.util.ArrayList;

import com.thp.spring.simplecontext.entity.Favoris;

public interface FavorisService {

	public void creerFavoris();

	public Favoris chooseFavorisSpecifications();

	public void afficherFavoris();

	public void supprimerFavoris();

	public void RetrouverAnnounce();

	public Favoris findFavoriById(int id);

	public void modifyFavori();

	public void enregistrerAnnonceFavori(int idFavori, String email, String pwd);

	public void afficherFavorisForAUser(int idUser);

	public ArrayList<Favoris> findFavoriByIdUser(int id);

}
