<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Vous êtes connecté en tant que : ${pseudo }</h1>
	<form action="/DemoContext/ServletAffichageApresConnexion" method="GET">
		<input type="submit" value="Deconnecter">
	</form>
</body>
</html>