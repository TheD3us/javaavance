package dal;

import java.util.List;

import bo.Contact;



public interface ContactDAO {
	Contact select(int id);
	List<Contact> selectAll();
	void insert(Contact contact);
	void update(Contact contact);
	void delete(int id);
}
