package servlet;

import java.io.IOException;
import java.time.LocalDate;

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
 * Servlet implementation class Annuaire
 */
@WebServlet("/Annuaire")
public class Annuaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    private int i = 0;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactBll contact = new ContactBll();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("dateNaissance");
		if(nom != null && prenom != null && dateNaissance != null) {
			LocalDate date = LocalDate.parse(dateNaissance);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Annuaire.jsp");
			for(Contact current : contact.selectAll()) {
				if(current.getNom().equalsIgnoreCase(nom) && current.getPrenom().equalsIgnoreCase(prenom) && current.getDateNaissance().isEqual(date)) {
					request.setAttribute("id", contact.selectAll().get(i).getId());
					request.setAttribute("nom", contact.selectAll().get(i).getNom() );
					request.setAttribute("prenom", contact.selectAll().get(i).getPrenom() );
					request.setAttribute("dateNaissance", contact.selectAll().get(i).getDateNaissance() );
					request.setAttribute("numeroTelephone", contact.selectAll().get(i).getNumeroTelephone() );
					request.setAttribute("reseauxSociaux", contact.selectAll().get(i).getUrlReseauxSociaux() );
					request.setAttribute("poste", contact.selectAll().get(i).getPoste() );
					request.setAttribute("specialite", contact.selectAll().get(i).speToString() );
				}
			}

			
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
