package bo;

public class Utilisateur {
	private int id;
	private String pseudo;
	private String motDePasse;
	
	
	public Utilisateur(String pseudo, String motDePasse) {
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	
	

}
