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
		<label>Veuillez insérer un id</label>
		<input type="number" name="index">
		<input type="submit" value="Chercher">
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