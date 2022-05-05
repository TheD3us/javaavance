package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ContactBll;

/**
 * Servlet implementation class SupprimerContact
 */
@WebServlet("/SupprimerContact")
public class SupprimerContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactBll contactBll;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	contactBll = new ContactBll();
    	super.init(config);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idContact = request.getParameter("id");
		int id = Integer.parseInt(idContact);
		contactBll.delete(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Annuaire.jsp");
		rd.forward(request, response);
		
	}

	
	

}
