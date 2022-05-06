<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Annuaire/ModifierContact" method="POST">
	<label>Nom</label>
	<input type="text" name="nom" value="${contact.nom }">
	<label>Prénom</label>
	<input type="text" name="prenom" value="${contact.prenom }">
	<label>Date de naissance</label>
	<input type="date" name="dateNaissance" value="${contact.dateNaissance }">
	<label>Numero de Téléphone</label>
	<input type="text" name="numeroTelephone" value="${contact.numeroTelephone }">
	<label>Url réseaux sociaux</label>
	<input type="text" name="url_reseaux" value="${contact.urlReseauxSociaux }">
	<label>Poste</label>
	<input type="text" name="poste" value="${contact.poste }">
	<label>Spécialité</label>
	<input type="text" name="spe1" value="${specialite }">
	<input type="submit" value="Modifier">
	</form>
</body>
</html>