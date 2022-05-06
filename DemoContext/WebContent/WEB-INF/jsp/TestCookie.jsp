<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie cookie</title>
</head>
<body>
	<form action="/DemoContext/ServletCookie" method="Get">
		<input type="text" name="couleur" placeholder="Couleur">
		<input type="submit" value="Valider">
	</form>
</body>

	<p style="color: ${cookie.preference.value}"> Ce texte est de couleur : ${cookie.preference.value } </p>
</html>