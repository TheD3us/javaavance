package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nombreMystere = 0;
	int compteur = 0;
	boolean gagne = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulaire() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	genererNombre(10,0);
    	
    	super.init(config);
    }
    
    public void genererNombre(int a, int b) {
    	nombreMystere = (int) (Math.random() * (a-b) + b);
    	System.out.println(nombreMystere);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		

		if(gagne == true) {
			String nombreDonneMin = request.getParameter("min");
			String nombreDonneMax = request.getParameter("max");
			int nombreMin = Integer.parseInt(nombreDonneMin);
			int nombreMax = Integer.parseInt(nombreDonneMax);
			if(nombreMin != 0 && nombreMax != 10) {
				
				genererNombre(nombreMax, nombreMin);
			}else {
				genererNombre(10, 0);
			}
			
			gagne = false;
			compteur = 0;
			response.sendRedirect("/CrazyNumber/HTML/Formulaire.html");
		}else {
			compteur++;
			System.out.println("Nombre essais : " + compteur);
			String nombreDonne = request.getParameter("num");
			int nombre = Integer.parseInt(nombreDonne);
			System.out.println(nombre);
			
			if(nombre == nombreMystere) {
				gagne = true;
				System.out.println(nombre);
				response.sendRedirect("/CrazyNumber/HTML/Reussite.html");
			}else {
				System.out.println(nombre);
				response.sendRedirect("/CrazyNumber/HTML/Echec.html");
			
		}
	}				
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeroString = String.valueOf(compteur);
		
		System.out.println("Sequence : " + numeroString);
		response.getWriter().append(numeroString);
		
	}

}
