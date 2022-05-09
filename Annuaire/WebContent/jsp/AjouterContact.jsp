<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Contact</title>
</head>
<%@include file="/jsp/Header.jsp"%>
<body>
	<form action="/Annuaire/AjouterContact" method="POST">
	<label>Nom</label>
	<input type="text" name="nom">
	<label>Prénom</label>
	<input type="text" name="prenom">
	<label>Date de naissance</label>
	<input type="date" name="dateNaissance">
	<label>Numero de Téléphone</label>
	<input type="text" name="numeroTelephone">
	<label>Url réseaux sociaux</label>
	<input type="text" name="url_reseaux">
	<label>Poste</label>
	<input type="text" name="poste" value="${posteDefaut }">
	<label>Spécialité</label>
	<input type="text" name="spe1">
	<input type="submit" value="Créer">
	</form>
</body>
</html>