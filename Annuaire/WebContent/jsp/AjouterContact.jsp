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
	<label>Pr�nom</label>
	<input type="text" name="prenom">
	<label>Date de naissance</label>
	<input type="date" name="dateNaissance">
	<label>Numero de T�l�phone</label>
	<input type="text" name="numeroTelephone">
	<label>Url r�seaux sociaux</label>
	<input type="text" name="url_reseaux">
	<label>Poste</label>
	<input type="text" name="poste" value="${posteDefaut }">
	<label>Sp�cialit�</label>
	<input type="text" name="spe1">
	<input type="submit" value="Cr�er">
	</form>
</body>
</html>