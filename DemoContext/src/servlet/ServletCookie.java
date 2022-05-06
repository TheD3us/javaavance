package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCookie
 */
@WebServlet("/ServletCookie")
public class ServletCookie extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String couleur = request.getParameter("couleur");
		if(request.getCookies() != null) {
			
			Cookie[] mesCookies = request.getCookies();	
			for(Cookie current : mesCookies) {
				if("preference".equals(current.getName())) {
					System.out.println("Le cookie préference vaut : " + current.getValue());
				}
			}
		}
		

		Cookie monCookie = new Cookie("preference", couleur);
		response.addCookie(monCookie);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/TestCookie.jsp");
		rd.forward(request, response);
	}

}
