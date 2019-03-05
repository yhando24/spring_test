package fr.iocean.dta.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Entreprise {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long identifiant;
	
	@Column(length = 45 ,  nullable=true)
	private String nom;
	

    @OneToMany(mappedBy = "entreprise" )
	private List<Employe> employes = new ArrayList<>();

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

}
