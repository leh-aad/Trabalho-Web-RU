<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    <ul class="nav navbar-nav navbar-left">
      <li><a href="/Trabalho_Web_RU">Principal</a></li>
      <li class="active"><a href="#">Cadastrar Aluno</a></li>
      <li><a href="funcionario-form">Cadastrar Funcionario</a></li>
      <li><a href="cardapio-form">Cadastrar Cardapio</a></li>
    </ul>
  </div>

	<div class="form">
		<form id="form-aluno-cadastro" action="cadastrar/aluno" method="post">
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
			<div class="form-group">
				<label for="curso">Curso:</label>
				<select id="curso" class="form-control" name="curso">
					<option value="cc">Ciencia da Computacao</option>
					<option value="dd">Design Digital</option>
					<option value="ec">Engenharia da Computacao</option>
					<option value="es">Engenharia de Software</option>
					<option value="rd">Redes de Computadores</option>
					<option value="si">Sistema de Informacao</option>
				</select>
			</div>
			<button class="btn btn-success btn-block" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>
