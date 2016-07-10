<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Novo Aluno</title>
	<link rel="stylesheet" type="text/css" href="../../../resource/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../../../resource/css/main.css">
	<script type="text/javascript" src="../../../resource/js/cadastro.js"></script>
</head>
<body>
	<div class="navbar navbar-default">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li class="active"><a href="#">Cadastar Funcionario</a></li>
			<li><a href="cadastrar/aluno">Cadastar Aluno</a></li>
		</ul>
	</div>
	<div class="form">
		<form id="form-funcionario-cadastro" action="cadastrarUsuario" method="post">
			<div class="form-group">
				<label for="codigo">Codigo:</label>
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
			<div class="form-group">
				<label for="tipo-usuario">Tipo de Usuario:</label>
				<select id="tipo-usuario" class="form-control" name="tipo">
					<option value="secretario">Secretario</option>
					<option value="nutricionista">Nutricionista</option>
					<option value="professor">Professor</option>
				</select>
			</div>
			<button class="btn btn-success btn-block" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>
