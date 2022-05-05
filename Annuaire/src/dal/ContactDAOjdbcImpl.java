package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Contact;

public class ContactDAOjdbcImpl implements ContactDAO {
	

	
	
	@Override
	public Contact select(int id) {
		Contact contact = new Contact();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM contact AS LEFT JOIN specialite AS s ON s.contact = c.id WHERE c.id = 1;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() != false) {
				contact.setId(id);
				contact.setNom(rs.getString("c.nom"));
				contact.setPrenom(rs.getString("prenom"));
				contact.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
				contact.setNumeroTelephone(rs.getString("numero_telephone"));
				contact.setUrlReseauxSociaux(rs.getString("url_reseaux"));
				contact.setPoste(rs.getString("poste"));
				contact.setSpecialite(new ArrayList<String>());
				contact.getSpecialite().add(rs.getString("s.nom"));
				
				
			}
			
			while(rs.next() != false) {
				contact.getSpecialite().add(rs.getString("s.nom"));
			}
			
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public List<Contact> selectAll() {
		Contact contact = new Contact();
		List<Contact> listContact = new ArrayList<Contact>();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT c.id, c.nom AS  nom_client , prenom, date_naissance, numero_telephone, url_reseaux, poste, s.nom AS nom_spe FROM contact AS c LEFT JOIN specialite AS s ON s.contact = c.id;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next() != false) {
				
				if(contact.getId() == rs.getInt("id")) {
					contact.getSpecialite().add(rs.getString("nom_client"));
				}else if(contact.getNom() == null) {
					contact = new Contact();
					contact.setId(rs.getInt("id"));
					contact.setNom(rs.getString("nom_client"));
					contact.setPrenom(rs.getString("prenom"));
					contact.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
					contact.setNumeroTelephone(rs.getString("numero_telephone"));
					contact.setUrlReseauxSociaux(rs.getString("url_reseaux"));
					contact.setPoste(rs.getString("poste"));
					contact.setSpecialite(new ArrayList<String>());
					contact.getSpecialite().add(rs.getString("nom_spe"));
				}else {
					listContact.add(contact);
					contact = new Contact();
					contact.setId(rs.getInt("id"));
					contact.setNom(rs.getString("nom_client"));
					contact.setPrenom(rs.getString("prenom"));
					contact.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
					contact.setNumeroTelephone(rs.getString("numero_telephone"));
					contact.setUrlReseauxSociaux(rs.getString("url_reseaux"));
					contact.setPoste(rs.getString("poste"));
					contact.setSpecialite(new ArrayList<String>());
					contact.getSpecialite().add(rs.getString("nom_spe"));
					
				}
				
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listContact;
	}

	@Override
	public void insert(Contact contact) {
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO contact (nom, prenom, date_naissance, numero_telephone, url_reseaux, poste) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, contact.getNom());
			ps.setString(2, contact.getPrenom());
			Date dateNaissance = Date.valueOf(contact.getDateNaissance());
			ps.setDate(3, dateNaissance);
			ps.setString(4, contact.getNumeroTelephone());
			ps.setString(5, contact.getUrlReseauxSociaux());
			ps.setString(6, contact.getPoste());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				contact.setId(rs.getInt(1));
			}
			for(String current : contact.getSpecialite()) {
				PreparedStatement ps2;
				ps2 = cnx.prepareStatement("INSERT INTO specialite (nom, contact) VALUES (?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
				ps2.setString(1, current);
				ps2.setInt(2, contact.getId());
				ps2.executeUpdate();
				rs = ps2.getGeneratedKeys();
			}

			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Contact contact) {
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("UPDATE contact SET nom = ?, prenom = ?, date_naissance = ?, numero_telephone = ?, url_reseaux = ?, poste = ? WHERE id = ?");
			ps.setString(1, contact.getNom());
			ps.setString(2, contact.getPrenom());
			Date dateNaissance = Date.valueOf(contact.getDateNaissance());
			ps.setDate(3, dateNaissance);
			ps.setString(4, contact.getNumeroTelephone());
			ps.setString(5, contact.getUrlReseauxSociaux());
			ps.setString(6, contact.getPoste());
			ps.setInt(7, contact.getId());
			ps.executeUpdate();
			for(String current : contact.getSpecialite()) {
				ps = cnx.prepareStatement("UPDATE specialite SET nom = ? WHERE contact = ?;");
				ps.setString(1, current);
				ps.setInt(2, contact.getId());
				ps.executeUpdate();
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cnx = ConnectionProvider.getConnection();
		try {

			PreparedStatement ps = cnx.prepareStatement("DELETE FROM contact WHERE id = ?");
			
			ps.setInt(1, id);
			ps.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
