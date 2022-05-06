package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextApplication
 */
@WebServlet("/ContextApplication")
public class ContextApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("couleurParDefaut", "black");
		
		request.getRequestDispatcher("/WEB-INF/jsp/TestContext.jsp").forward(request, response);
	}



}
