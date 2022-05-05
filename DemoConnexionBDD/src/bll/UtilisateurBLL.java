package bll;

import java.util.List;

import bo.Utilisateur;
import dal.UtilisateurDAO;
import dal.UtilisateurDAOjdbcImpl;

public class UtilisateurBLL {
	private UtilisateurDAO dao;
	
	public UtilisateurBLL() {
		dao = new UtilisateurDAOjdbcImpl();
	}
	
	public List<Utilisateur> selectAll(){
		return dao.selectAll();
	}
	
	public Utilisateur select(int id) {
		if(id >= 0) {
			return dao.select(id);
		}
		return null;
	}
	
	public void insert(Utilisateur user) {
		if(user.getMotDePasse().length() > 30 || user.getPseudo().length() > 30)
		{
			return;
		}
		dao.insert(user);
	}
	
	public void update(Utilisateur user) {
		if(user.getId() <0) return;
		if(user.getMotDePasse().length() > 30 || user.getPseudo().length() > 30)
		{
			return;
		}
		
		dao.update(user);
	}
	
	public void delete(int id) {
		if(id <0) return;
		
		dao.delete(id);
	}
}
