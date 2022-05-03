package bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String nom;
	private String prenom;
	private LocalDateTime dateNaissance;
	private String numeroTelephone;
	private String urlReseauxSociaux;
	private String poste;
	private List<String> specialite = new ArrayList<String>();
	
	
	
	public Contact(String nom, String prenom, LocalDateTime dateNaissance, String numeroTelephone,
			String urlReseauxSociaux, String poste, List<String> specialite) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numeroTelephone = numeroTelephone;
		this.urlReseauxSociaux = urlReseauxSociaux;
		this.poste = poste;
		this.specialite = specialite;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDateTime getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDateTime dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getUrlReseauxSociaux() {
		return urlReseauxSociaux;
	}
	public void setUrlReseauxSociaux(String urlReseauxSociaux) {
		this.urlReseauxSociaux = urlReseauxSociaux;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public List<String> getSpecialite() {
		return specialite;
	}
	public void setSpecialite(List<String> specialite) {
		this.specialite = specialite;
	}
	
	
	public String speToString() {
		String text = " ";
		for(String current : specialite) {
			text = text + " " + current;
		}
		
		return text;
		
	}
	
	
	
}
