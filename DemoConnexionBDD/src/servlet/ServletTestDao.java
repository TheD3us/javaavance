package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletTestDao
 */
@WebServlet("/ServletTestDao")
public class ServletTestDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL utilisateurBll;
	
	@Override
		public void init(ServletConfig config) throws ServletException {
		utilisateurBll = new UtilisateurBLL();
			super.init(config);
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Utilisateur u1 = new Utilisateur("koko456", "mdp1");
	 utilisateurBll.insert(u1);
	 
	 u1.setPseudo("koko");
	 u1.setMotDePasse("nonoonono");
	 
	 utilisateurBll.update(u1);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
