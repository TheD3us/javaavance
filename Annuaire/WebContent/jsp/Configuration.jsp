<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Configuration</title>
</head>
<%@include file="/jsp/Header.jsp"%>
<body>
<h1>Poste par défaut</h1>
<form action="/Annuaire/Configuration" method="POST">
<input type="text" name="posteDefaut">
<input type="submit" value="Envoyer">
<p>Vous avez accedé à cette page ${compteur } fois</p>

</form>
</body>
</html>