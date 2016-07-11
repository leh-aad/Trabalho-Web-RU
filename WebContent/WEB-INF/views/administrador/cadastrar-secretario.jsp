<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Novo Aluno</title>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="resource/css/main.css">
	<script type="text/javascript" src="resource/js/cadastro.js"></script>
</head>
<body>
	<div class="navbar navbar-default">
		<ul class="nav navbar-nav">
			<li><a href="/Trabalho_Web_-_RU">Home</a></li>
			<li><a href="cadastrar/aluno">Cadastar Aluno</a></li>
			<li class="active"><a href="#">Cadastar Secretario</a></li>
			<li><a href="cadastrar/cardapio">Cadastrar Cardapio</a></li>
		</ul>
	</div>
	<div class="form col-md-4 col-md-offset-4">
		<form id="form-secretario-cadastro" action="secretario-cadastrar" method="post">
			<div class="form-group">
				<label for="codigo">Matricula:</label>
				<input id="codigo" class="form-control" type="text" name="codigo">
				<span class="erro" id="erro-codigo"></span>
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
			<button class="btn btn-success btn-block" type="submit">Cadastrar</button>
		</form>

		<c:if test="${ not empty feedback_cadastro }">
			<div class="erro">
				<hr>
				<span>${ feedback_cadastro }</span>
			</div>
		</c:if>

	</div>
</body>
</html>
