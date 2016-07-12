<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Novo Aluno</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<script type="text/javascript" src="resources/js/cadastro.js"></script>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top">
		<div class="navbar-header">
			<span class="navbar-brand">Tickets RU</span>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="administrador">Principal</a></li>
			<li><a href="cadastrar-aluno-form">Cadastar Aluno</a></li>
			<li class="active"><a href="#">Cadastar Secretario</a></li>
			<li><a href="cadastrar-cardapio-form">Cadastrar Cardapio</a></li>
			<li><a href="logout">Sair</a></li>
		</ul>
	</div>

	<div class="col-md-4 col-md-offset-4">
		<form id="form-cadastro-usuario" action="cadastrar-secretario" method="post">
			<div class="form-group">
				<label for="matricula">Matricula:</label>
				<input id="matricula" class="form-control" type="text" name="matricula">
				<span class="erro" id="erro-matricula"></span>
			</div>

			<div class="form-group">
				<label for="nome">Nome:</label>
				<input id="nome" class="form-control" type="text" name="nome">
				<span class="erro" id="erro-nome"></span>
			</div>

			<div class="form-group">
				<label for="email">E-mail:</label>
				<input id="email" class="form-control" type="text" name="email">
				<span class="erro" id="erro-email"></span>
			</div>

			<div class="form-group checkbox">
				<label><input name="administrador" type="checkbox" value="1">Administrador</label>
			</div>

			<button class="btn btn-success btn-block" type="submit">Cadastrar</button>
		</form>

		<c:if test="${ not empty feedback_secretario }">
			<div class="erro form-control-feedback">
				<hr>
				<span>${ feedback_secretario }</span>
			</div>
		</c:if>

	</div>

	<jsp:include page="../rodape.jsp"/>

</body>
</html>
