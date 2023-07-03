package fr.humanbooster.ibrahim.aeroport.dao;

public class Requetes {

	public static final String REQUETE_AJOUT_AEROPORT ="INSERT INTO Aeroport (nom) VALUES (?)";
    public static final String REQUETE_SELECTION_AEROPORT_PAR_ID ="SELECT * FROM Aeroport WHERE id=?";
    public static final String REQUETE_SELECTION_AEROPORT_ALL ="SELECT * FROM Aeroport ";
    public static final String REQUETE_MISE_A_JOUR_NOM_AEROPORT ="UPDATE `Aeroport` SET ``nom` =(?) WHERE id=?";
}
