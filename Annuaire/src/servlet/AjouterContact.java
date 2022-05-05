package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ContactBll;
import bo.Contact;

/**
 * Servlet implementation class AjouterContact
 */
@WebServlet("/AjouterContact")
public class AjouterContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactBll contactBll;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterContact() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	contactBll = new ContactBll();
    	super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contact contact = new Contact();
		
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
		
		contactBll.insert(contact);
		response.sendRedirect("/Annuaire/jsp/AjouterContact.jsp");
		
		
	}

}
