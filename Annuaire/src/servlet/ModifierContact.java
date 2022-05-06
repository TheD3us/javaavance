package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ContactBll;
import bo.Contact;

/**
 * Servlet implementation class ModifierContact
 */
@WebServlet("/ModifierContact")
public class ModifierContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactBll contactBll;
    private Contact contact = new Contact();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	contactBll = new ContactBll();
    	super.init(config);
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idContact = request.getParameter("id");
		if(idContact != null)
		{
			int id = Integer.parseInt(idContact);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ModifierContact.jsp");
			contact = contactBll.select(id);
			request.setAttribute("contact", contact);
			request.setAttribute("specialite", contact.speToString() );
			
			rd.forward(request, response);
		}
		

		
		


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		contact.setNom(request.getParameter("nom"));
		contact.setPrenom(request.getParameter("prenom"));
		String date = request.getParameter("dateNaissance");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateFinal = LocalDate.parse(date, dateFormat);
		contact.setDateNaissance(dateFinal);
		contact.setNumeroTelephone(request.getParameter("numeroTelephone"));
		contact.setUrlReseauxSociaux(request.getParameter("url_reseaux"));
		contact.setPoste(request.getParameter("poste"));
		List<String> listSpecialite = new ArrayList<String>();
		listSpecialite.add(request.getParameter("spe1"));
		contact.setSpecialite(listSpecialite);
		
		contactBll.update(contact);
		response.sendRedirect("/Annuaire/jsp/AjouterContact.jsp");
	}

}
