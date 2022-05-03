package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Contact;

/**
 * Servlet implementation class Annuaire
 */
@WebServlet("/Annuaire")
public class Annuaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private Contact contact1 = new Contact("Leblanc", "Simon", LocalDateTime.of(1990, 6, 20, 8, 40), "0546982815",
		"/sugarDaddy", "Agent d'entretien", null); 
    private Contact contact2 = new Contact("Gerde", "Agathe", LocalDateTime.of(1970, 8, 18, 12, 12), "0613458732",
		"/bestScientist", "Chercheur", null); 
    private List<Contact> tabContact = new ArrayList<Contact>();
    private int i = 0;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void ajouterContact() {
    	List<String> spe1 = new ArrayList<String>();
    	List<String> spe2 = new ArrayList<String>();
    	spe1.add("Verre");
    	spe1.add("Papier");
    	spe2.add("Biologie");
    	spe2.add("economie");
    	contact1.setSpecialite(spe1);
    	contact2.setSpecialite(spe2);
    	tabContact.add(contact1);
    	tabContact.add(contact2);
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	ajouterContact();
    	super.init(config);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String index = request.getParameter("index");
		if(index != null) {
			i = Integer.valueOf(index);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Annuaire.jsp");

			request.setAttribute("nom", tabContact.get(i).getNom() );
			request.setAttribute("prenom", tabContact.get(i).getPrenom() );
			request.setAttribute("dateNaissance", tabContact.get(i).getDateNaissance() );
			request.setAttribute("numeroTelephone", tabContact.get(i).getNumeroTelephone() );
			request.setAttribute("reseauxSociaux", tabContact.get(i).getUrlReseauxSociaux() );
			request.setAttribute("poste", tabContact.get(i).getPoste() );
			request.setAttribute("specialite", tabContact.get(i).speToString() );
			
			rd.forward(request, response);
		}else {
			response.sendRedirect("/Annuaire/jsp/Annuaire.jsp");
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
