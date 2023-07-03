package fr.humanbooster.ibrahim.aeroport.business;

import java.util.Date;

public class Vol {
    
    private Date dateHeureDepart;
    private Date dateHeureArrive;
    private double prixEnEuro;
    private Aeroport aeroportArrive;
    private Aeroport aeroportDepart;
    private Compagnie compagnie;
    
    // Constructeur
    
    public Vol() {
    	super();
    }

    public Vol(Date dateHeureDepart, Date dateHeureArrive, double prixEnEuro, Aeroport aeroportArrive,
			Aeroport aeroportDepart, Compagnie compagnie) {
		super();
		this.dateHeureDepart = dateHeureDepart;
		this.dateHeureArrive = dateHeureArrive;
		this.prixEnEuro = prixEnEuro;
		this.aeroportArrive = aeroportArrive;
		this.aeroportDepart = aeroportDepart;
		this.compagnie = compagnie;
	}

	// Getters et Setters

    
    public Date getDateHeureDepart() {
        return dateHeureDepart;
    }
    
    public void setDateHeureDepart(Date dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }
    
    public Date getDateHeureArrive() {
        return dateHeureArrive;
    }
    
    public void setDateHeureArrive(Date dateHeureArrive) {
        this.dateHeureArrive = dateHeureArrive;
    }
    
    public double getPrixEnEuro() {
        return prixEnEuro;
    }
    
    public void setPrixEnEuro(double prixEnEuro) {
        this.prixEnEuro = prixEnEuro;
    }
    
    public Aeroport getAeroportArrive() {
        return aeroportArrive;
    }
    
    public void setAeroportArrive(Aeroport aeroportArrive) {
        this.aeroportArrive = aeroportArrive;
    }
    
    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }
    
    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }
    
    public Compagnie getCompagnie() {
        return compagnie;
    }
    
    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    // ToString
	@Override
	public String toString() {
		return "Vol [dateHeureDepart=" + dateHeureDepart + ", dateHeureArrive=" + dateHeureArrive + ", prixEnEuro="
				+ prixEnEuro + ", aeroportArrive=" + aeroportArrive + ", aeroportDepart=" + aeroportDepart
				+ ", compagnie=" + compagnie + "]";
	}
}

