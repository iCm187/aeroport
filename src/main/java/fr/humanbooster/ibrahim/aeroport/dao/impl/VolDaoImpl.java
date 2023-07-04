package fr.humanbooster.ibrahim.aeroport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ibrahim.aeroport.business.Aeroport;
import fr.humanbooster.ibrahim.aeroport.business.Compagnie;
import fr.humanbooster.ibrahim.aeroport.business.Vol;
import fr.humanbooster.ibrahim.aeroport.dao.ConnexionBdd;
import fr.humanbooster.ibrahim.aeroport.dao.Requetes;
import fr.humanbooster.ibrahim.aeroport.dao.VolDao;
import fr.humanbooster.ibrahim.aeroport.dao.AeroportDao;
import fr.humanbooster.ibrahim.aeroport.dao.CompagnieDao;


public class VolDaoImpl implements VolDao {
	
    private Connection connection;
    private AeroportDao aeroportDao = new AeroportDaoImpl();
    private CompagnieDao compagnieDao = new CompagnieDaoImpl();

    public VolDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vol createflight(Vol vol) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_AJOUT_VOL, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setDate(1, new java.sql.Date(vol.getDateHeureDepart().getTime()));
        ps.setDate(2, new java.sql.Date(vol.getDateHeureArrive().getTime()));
        ps.setDouble(3, vol.getPrixEnEuro());
        ps.setLong(4, vol.getAeroportArrive().getId());
        ps.setLong(5, vol.getAeroportDepart().getId());
        ps.setLong(6, vol.getCompagnie().getId());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            vol.setId(id);
        }

        return vol;
    }

    @Override
    public List<Vol> findAllFlightsOrderByPrice() throws SQLException {
        List<Vol> vols = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_SELECTION_TOUS_VOLS_TRIES_PAR_PRIX);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Vol vol = new Vol();
            // Remplir les informations du vol à partir des colonnes de la table
            vol.setId(rs.getLong("id"));
            vol.setDateHeureDepart(rs.getTimestamp("dateHeureDepart"));
            vol.setDateHeureArrive(rs.getTimestamp("dateHeureArrive"));
            vol.setPrixEnEuro(rs.getDouble("PrixEnEuro"));
            // Récupérer et définir les objets Aeroport et Compagnie associés au vol
            Aeroport aeroportArrive = aeroportDao.getAeroportById(rs.getLong("Id_Aeroport_Arrive"));
            Aeroport aeroportDepart = aeroportDao.getAeroportById(rs.getLong("Id_Aeroport_Depart"));
            vol.setAeroportArrive(aeroportArrive);
            vol.setAeroportDepart(aeroportDepart);
            Compagnie compagnie = compagnieDao.findOneCompagnieById(rs.getLong("Id_Compagnie"));
            vol.setCompagnie(compagnie);
            // Ajouter le vol à la liste
            vols.add(vol);
        }
        return vols;
    }

    @Override
    public Vol updateVol(Vol vol) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.REQUETE_MISE_A_JOUR_VOL);
        ps.setDate(1, new java.sql.Date(vol.getDateHeureDepart().getTime()));
        ps.setDate(2, new java.sql.Date(vol.getDateHeureArrive().getTime()));
        ps.setDouble(3, vol.getPrixEnEuro());
        ps.setLong(4, vol.getAeroportArrive().getId());
        ps.setLong(5, vol.getAeroportDepart().getId());
        ps.setLong(6, vol.getCompagnie().getId());
        ps.setLong(7, vol.getId());
        ps.executeUpdate();
        return vol;
    }
}
