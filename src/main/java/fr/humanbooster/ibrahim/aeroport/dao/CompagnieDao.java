package fr.humanbooster.ibrahim.aeroport.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ibrahim.aeroport.business.Compagnie;

public interface CompagnieDao {

	// C
    Compagnie createCompagnie(Compagnie compagnie) throws SQLException;

    // R
    List<Compagnie> findAllCompagnies() throws SQLException;
    Compagnie findOneCompagnieById(long id) throws SQLException;

    // U

    // D
    boolean delete(Long id) throws SQLException;

}

