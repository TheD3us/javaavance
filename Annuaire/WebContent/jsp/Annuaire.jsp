<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annuaire Pro</title>
</head>
<%@include file="/jsp/Header.jsp"%>
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
	
		<form method="GET" action="/Annuaire/AjouterContact">
		<input type="submit" value="Ajouter"/>
	</form>
	
	<form method="GET" action="/Annuaire/SupprimerContact">
		<input type="hidden" value="${id}" name="id"/>
		<input type="submit" value="Supprimer"/>
	</form>
	<form method="GET" action="/Annuaire/ModifierContact">
		<input type="hidden" value="${id}" name="id"/>
		<input type="submit" value="Modifier"/>
	</form>
	
		<form method="GET" action="/Annuaire/Configuration">
		<input type="submit" value="Configuration"/>
	</form>
	${nom}<br>
	${prenom}<br>
	${dateNaissance}<br>
	${numeroTelephone}<br>
	${reseauxSociaux}<br>
	${poste}<br>
	${specialite}<br>
	
	<c:if test="${!empty listContact}">
		<label>Filtrer par :</label>
		<select>
		<option value="nom">Nom</option>
		<option value="prenom">prenom</option>
		<option value="numeroTelephone">Numero de telephone</option>
		<option value="poste">Métier</option>
		<option value="specialite">Spécialité</option>
		
		</select>
		<table>
		<tbody>
		<c:forEach var="contact" items="${listContact }">
			<tr>
				<td>${contact.nom }</td>
				<td>${contact.prenom}</td>
				<td>${contact.dateNaissance }</td>
				<td>${contact.numeroTelephone }</td>
				<td>${contact.urlReseauxSociaux }</td>
				<td>${contact.poste }</td>
				<td>${contact.specialite }</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	</c:if>
	
</body>
</html>