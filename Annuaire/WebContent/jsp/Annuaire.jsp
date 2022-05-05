<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annuaire Pro</title>
</head>
<body>
	<form action="/Annuaire/Annuaire" method="GET">
		<label>Nom</label>
		<input type="text" name="nom">
		<label>prenom</label>
		<input type="text" name="prenom">
		<label>Date de naissance</label>
		<input type="date" name="dateNaissance">
		<input type="submit" value="Chercher">
	</form>
	
	
	
	<form method="GET" action="/Annuaire/SupprimerContact">
		<input type="hidden" value="${id}" name="id"/>
		<input type="submit" value="Supprimer"/>
	</form>
	${nom}<br>
	${prenom}<br>
	${dateNaissance}<br>
	${numeroTelephone}<br>
	${reseauxSociaux}<br>
	${poste}<br>
	${specialite}<br>
	
</body>
</html>