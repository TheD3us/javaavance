package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bo.Utilisateur;

public class UtilisateurDAOjdbcImpl implements UtilisateurDAO{

	private List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();


	
	@Override
	public Utilisateur select(int id) {
		Utilisateur user = new Utilisateur();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateur WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() != false) {
				
				
				user.setId(id);
				user.setPseudo(rs.getString("pseudo"));
				user.setMotDePasse(rs.getString("mot_de_passe"));
				
				
			}	
			
		cnx.close();
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
	}

	@Override
	public List<Utilisateur> selectAll() {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateur;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next() != false) {
				Utilisateur user = new Utilisateur();
				int id = rs.getInt("id");
				user.setId(id);
				user.setPseudo(rs.getString("pseudo"));
				user.setMotDePasse(rs.getString("mot_de_passe"));
				
				listUtilisateur.add(user);
			}
			
			
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUtilisateur;
	}

	@Override
	public void insert(Utilisateur utilisateur) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO utilisateurs(pseudo, mot_de_passe) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getMotDePasse());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setId(rs.getInt(1));
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Utilisateur utilisateur) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("UPDATE utilisateurs SET pseudo = ?, mot_de_passe = ? WHERE id = ?");
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getMotDePasse());
			ps.setInt(3, utilisateur.getId());
			ps.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM utilisateurs WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
