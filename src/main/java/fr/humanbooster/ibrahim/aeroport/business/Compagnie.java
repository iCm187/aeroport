package fr.humanbooster.ibrahim.aeroport.business;

import java.util.ArrayList;
import java.util.List;

public class Compagnie {

	private Long id;
	private String nom;
	private List<Vol> vols = new ArrayList<>();
	private long idAeroport;

	public Compagnie() {
		super();
	}

	public Compagnie(String nom, List<Vol> vols) {
		super();
		this.nom = nom;
		this.vols = vols;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public long getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(long idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Compagnie [id=" + id + ", nom=" + nom + ", vols=" + vols + ", idAeroport=" + idAeroport + "]";
	}

}
