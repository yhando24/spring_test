package fr.iocean.dta.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Employe {

	public Employe() {
	}

	public Employe(Long identifiant, String prenom, String nom, String numeroSS, BigDecimal salaire,
			LocalDate dateEmbauche) {

		this.identifiant = identifiant;
		this.prenom = prenom;
		this.nom = nom;
		this.numeroSS = numeroSS;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long identifiant;
	
	@Column( nullable=true, length = 45)
	private String prenom;

	@Column( nullable=true, length = 45)
	private String nom;

	@Column( nullable=true, length = 45)
	private String numeroSS;

	@Column( nullable=true)
	private BigDecimal salaire;
	
	
	@ManyToOne
	@JoinColumn(name="id_type_entreprise")
	private Entreprise entreprise;
	
	@Column( nullable=true)
	private LocalDate dateEmbauche;

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}

	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Employe [identifiant=" + identifiant + ", prenom=" + prenom + ", nom=" + nom + ", numeroSS=" + numeroSS
				+ ", salaire=" + salaire + ", dateEmbauche=" + dateEmbauche + "]";
	}

}
