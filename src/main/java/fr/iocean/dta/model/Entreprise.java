package fr.iocean.dta.model;

import java.util.ArrayList;
import java.util.List;

public class Entreprise {

	private Long identifiant;

	private String nom;

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
