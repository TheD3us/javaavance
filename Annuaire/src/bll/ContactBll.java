package bll;

import java.time.LocalDate;
import java.util.List;

import bo.Contact;
import dal.ContactDAO;
import dal.ContactDAOjdbcImpl;

public class ContactBll {
	private ContactDAO dao;
	
	public ContactBll() {
		dao = new ContactDAOjdbcImpl();
	}
	
	public List<Contact> selectAll(){
		return dao.selectAll();
	}
	
	public Contact select(int id) {
		if(id > -1) {
			return dao.select(id);
		}
		return null;
	}
	
	public void insert(Contact contact) {
		if(contact.getNom().length() > 50 || contact.getPrenom().length() > 30 || contact.getDateNaissance().isAfter(LocalDate.now()) || contact.getNumeroTelephone().length() != 10 
				|| contact.getUrlReseauxSociaux().length() > 30 || contact.getPoste().length() > 30)
		{
			System.out.println("Attention l'un des critères est vide ou défaillant");
			return;
		}
		for(String current : contact.getSpecialite()) {
			if(current.length() > 30) {
				System.out.println("Erreur ajout Specialité");
				return;
			}
		}
		dao.insert(contact);
	}
	
	public void update(Contact contact) {
		if(contact.getNom().length() > 50 || contact.getPrenom().length() > 30 || contact.getDateNaissance().isAfter(LocalDate.now()) || contact.getNumeroTelephone().length() != 10 
				|| contact.getUrlReseauxSociaux().length() > 30 || contact.getPoste().length() > 30) {
			return;
		}
		dao.update(contact);
	}
	
	public void delete(int id) {
		if(id < 0) return;
		dao.delete(id);
	}
}
