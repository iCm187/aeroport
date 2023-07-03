package fr.humanbooster.ibrahim.aeroport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ibrahim.aeroport.business.Aeroport;
import fr.humanbooster.ibrahim.aeroport.dao.AeroportDao;
import fr.humanbooster.ibrahim.aeroport.dao.ConnexionBdd;
import fr.humanbooster.ibrahim.aeroport.dao.Requetes;


public class AeroportDaoImpl implements AeroportDao {

	private Connection connection;

	public AeroportDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Aeroport createAeroport(Aeroport aeroport) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_AJOUT_AEROPORT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, aeroport.getNom());
		ps.executeQuery();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		aeroport.setId(rs.getLong(1));
		return aeroport;
	}

	@Override
	public Aeroport getAeroportById(long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_SELECTION_AEROPORT_PAR_ID);
		ps.setLong(1, id);
		ResultSet resultSet = ps.executeQuery();
		
		if (resultSet.next()) {
			Aeroport aeroport = new Aeroport();
			aeroport.setId(resultSet.getLong("id"));
			aeroport.setNom(resultSet.getString("nom"));
			return aeroport;
		}
		return null;
	}
	
	@Override
	public List<Aeroport> getAllAeroports() throws SQLException {
		List<Aeroport> aeroports = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_SELECTION_AEROPORT_ALL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aeroport aeroport = new Aeroport();
			aeroport.setId(rs.getLong("id"));
			aeroport.setNom(rs.getString("nom"));
			aeroports.add(aeroport);
		}
		return aeroports;
	}


	@Override
	public Aeroport updateAeroport(Aeroport aeroport) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_MISE_A_JOUR_NOM_AEROPORT);
		ps.setString(1, aeroport.getNom());
		ps.setLong(2, aeroport.getId());
		ps.executeUpdate();
		return aeroport;
	}
}
