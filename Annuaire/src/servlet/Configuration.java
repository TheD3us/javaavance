package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Configuration
 */
@WebServlet("/Configuration")
public class Configuration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int compteur = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Configuration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		compteur++;
		HttpSession session = request.getSession();
		session.setAttribute("compteur", compteur);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Configuration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String posteDefaut = request.getParameter("posteDefaut");
		Cookie cookie = new Cookie("posteDefaut", posteDefaut);
		response.addCookie(cookie);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Annuaire.jsp");
		
		rd.forward(request, response);
	}

}
