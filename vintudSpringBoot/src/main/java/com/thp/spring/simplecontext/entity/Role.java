package com.thp.spring.simplecontext.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRole;

	private String nom;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Role() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getRole_id() {
		return idRole;
	}

	public void setRole_id(Long role_id) {
		this.idRole = role_id;
	}

	public Role(Long role_id, String nom) {
		this.idRole = role_id;
		this.nom = nom;
	}

}