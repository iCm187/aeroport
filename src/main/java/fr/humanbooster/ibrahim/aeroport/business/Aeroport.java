package fr.humanbooster.ibrahim.aeroport.business;

public class Aeroport {

	private Long id;
	private String nom;
	
	
	public Aeroport() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Aeroport [id=" + id + ", nom=" + nom + "]";
	}
	
}
