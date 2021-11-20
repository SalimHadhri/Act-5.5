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
	private Long idRole ;
	
	
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

	public Collection<User> getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(Collection<User> usersRole) {
		this.usersRole = usersRole;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + idRole + ", nom=" + nom + ", usersRole=" + usersRole + "]";
	}
	
	

}
