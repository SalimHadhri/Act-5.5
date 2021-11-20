package com.thp.spring.entity;




import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;




@Entity
@Table(name = "Category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
   

   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCategory ;
    
    
	private String name  ;
	private String description  ;
	
	
    @OneToMany(mappedBy="categoryAnnonce")
    private Collection<Announcement> annoncesCategory ;
    
    
	
	public Category() {
	}

	public Long getId_category() {
		return idCategory;
	}

	
	
	
	


	public void setId_category(Long id_category) {
		this.idCategory = id_category;
	}

	public Category(Long id_category, String name, String description) {
		this.idCategory = id_category;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Announcement> getAnnoncesCategory() {
		return annoncesCategory;
	}

	public void setAnnoncesCategory(Collection<Announcement> annoncesCategory) {
		this.annoncesCategory = annoncesCategory;
	}

	@Override
	public String toString() {
		return "Category [id_category=" + idCategory + ", name=" + name + ", description=" + description
				+ ", annoncesCategory=" + annoncesCategory + "]";
	}



}
