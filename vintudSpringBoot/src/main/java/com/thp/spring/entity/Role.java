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
@Table(name = "Role")
public class Role  implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id ;
	
	
	private String nom ;
	
	
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToMany(mappedBy="role")
    private Collection<User> usersRole ;
    
	
	public Role() {
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}



	public Role(int role_id, String nom) {
		super();
		this.role_id = role_id;
		this.nom = nom;
	}

	public Collection<User> getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(Collection<User> usersRole) {
		this.usersRole = usersRole;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", nom=" + nom + ", usersRole=" + usersRole + "]";
	}
	
	

}
