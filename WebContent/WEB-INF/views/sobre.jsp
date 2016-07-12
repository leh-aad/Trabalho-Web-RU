<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap.css" />
<title>Sobre - Tickets RU</title>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top">
		<div class="navbar-header">
			<span class="navbar-brand">Tickets RU</span>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<c:choose>
				<c:when test="${not empty usuario }">
					<li><a href="${usuario.tipoUsuario}">Principal</a></li>
					<li><a href="next-cardapio">Cardapio do Proximo Dia</a></li>
					<li class="active"><a href="about">Sobre</a></li>				
					<li><a href="logout">Sair</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/Trabalho_Web_-_RU/">Principal</a></li>
					<li><a href="next-cardapio">Cardapio do Proximo Dia</a></li>
					<li class="active"><a href="about">Sobre</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<div class="container">
		<h1 class="text-success col-md-offset-4">Tickets RU</h1>
		<h4 class="col-md-offset-3">Um sistema para venda e utilizacao
			dos tickets usados no RU.</h4>
		<h4 class="col-md-offset-3">Tem o intuito de diminuir o
			despedricio de papel.</h4>
	</div>

	<jsp:include page="rodape.jsp" />

</body>
</html>
