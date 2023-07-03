package fr.humanbooster.ibrahim.aeroport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ibrahim.aeroport.business.Compagnie;
import fr.humanbooster.ibrahim.aeroport.dao.CompagnieDao;
import fr.humanbooster.ibrahim.aeroport.dao.ConnexionBdd;
import fr.humanbooster.ibrahim.aeroport.dao.Requetes;

public class CompagnieDaoImpl implements CompagnieDao {

	private Connection connection;

	public CompagnieDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Compagnie createCompagnie(Compagnie compagnie) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_AJOUT_COMPAGNIE,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, compagnie.getNom());
		ps.setLong(2, compagnie.getIdAeroport());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			compagnie.setId(rs.getLong(1));
		}
		return compagnie;
	}

	@Override
	public Compagnie findOneCompagnieById(long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_SELECTION_COMPAGNIE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Compagnie compagnie = new Compagnie();
			compagnie.setId(rs.getLong("Id_Compagnie"));
			compagnie.setNom(rs.getString("nom"));
			compagnie.setIdAeroport(rs.getLong("Id_Aeroport"));
			return compagnie;
		}
		return null;
	}

	@Override
	public List<Compagnie> findAllCompagnies() throws SQLException {
		List<Compagnie> compagnies = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_SELECTION_COMPAGNIE_ALL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Compagnie compagnie = new Compagnie();
			compagnie.setId(rs.getLong("Id_Compagnie"));
			compagnie.setNom(rs.getString("nom"));
			compagnie.setIdAeroport(rs.getLong("Id_Aeroport"));
			compagnies.add(compagnie);
		}
		return compagnies;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_SUPPRESSION_COMPAGNIE);
		ps.setLong(1, id);
		return ps.execute();
	}
}
