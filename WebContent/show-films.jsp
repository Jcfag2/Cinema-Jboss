<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films</title>
</head>
<body>
<h2>Liste des films</h2>
<h3>Vous avez ${cnt } articles dans votre panier</h3>
<table>
	<c:forEach items="${films }" var="film">
		<tr><td>${film.titre }</td>
			<td>${film.realisateur }</td>
			<td>${film.duree } minutes</td>
			<td>${film.dateSortie }</td>
			<td>||Prix : ${film.prixHT }€</td>
			<td><a href="AjouterAuPanierServlet?id=${film.id }">Ajouter au Panier</a></td>
		</tr>
		
	</c:forEach>
</table>
<a href="AfficherPanier">Afficher le panier</a>
<a href="index.jsp">Retour</a>
</body>
</html>