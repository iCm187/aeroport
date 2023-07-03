package fr.humanbooster.ibrahim.aeroport.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ibrahim.aeroport.business.Aeroport;

public interface AeroportDao {
	
	//Create
	Aeroport createAeroport(Aeroport aeroport) throws SQLException;

	//R
	List<Aeroport> getAllAeroports() throws SQLException;
	Aeroport getAeroportById(long id) throws SQLException;

	//U
	Aeroport updateAeroport(Aeroport aeroport) throws SQLException;

	//D
	//void deleteAeroport(Aeroport aeroport) throws SQLException;

}
