package dal;

import java.util.List;

import bo.Utilisateur;

public interface UtilisateurDAO {
	Utilisateur select(int id);
	List<Utilisateur> selectAll();
	void insert(Utilisateur utilisateur);
	void update(Utilisateur utilisateur);
	void delete(int id);
}
