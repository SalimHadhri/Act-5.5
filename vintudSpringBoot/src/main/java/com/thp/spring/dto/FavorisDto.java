package com.thp.spring.dto;


public class FavorisDto {
	
	

	

	private Long idFavoris ;
    
    
	private String dateAjout ;
	
	

	



	

    
	public FavorisDto() {
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

	public FavorisDto(Long id_favoris , String dateAjout) {
		this.idFavoris = id_favoris;
		this.dateAjout = dateAjout;
	}


	@Override
	public String toString() {
		return "FavorisDto [idFavoris=" + idFavoris + ", dateAjout=" + dateAjout + "]";
	}


	public Long getIdFavoris() {
		return idFavoris;
	}


	public void setIdFavoris(Long idFavoris) {
		this.idFavoris = idFavoris;
	}



	

}
