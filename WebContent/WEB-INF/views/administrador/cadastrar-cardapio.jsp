<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Novo Aluno</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/main.css">
	<script type="text/javascript" src="../resources/js/cadastro.js"></script>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top">
		<div class="navbar-header">
			<span class="navbar-brand">Tickets RU</span>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="../administrador">Principal</a></li>
			<li><a href="../cadastrar/aluno">Cadastrar Aluno</a></li>
			<li><a href="../cadastrar/secretario">Cadastrar Secretario</a></li>
			<li class="active"><a href="#">Cadastrar Cardapio</a></li>
			<li><a href="../logout">Sair</a></li>
		</ul>
	</div>

	<div class="container">

		<div class="col-md-8 col-md-offset-2">

			<form id="form-cardapio" class="form-horizontal" action="cardapio-cadastrar" method="post">

				<div class="form-group">
					<label class="control-label col-sm-3" for="data">Dia da Semana:</label>
					<div class="col-sm-9">
						<select id="data" class="form-control" name="data">
							<option value="2">Segunda-Feira</option>
							<option value="3">Terca-Feira</option>
							<option value="4">Quarta-Feira</option>
							<option value="5">Quinta-Feira</option>
							<option value="6">Sexta-Feira</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="horario">Horario:</label>
					<div class="col-sm-9">
						<select id="horario" class="form-control" name="tipo">
							<option value="0">Almoco</option>
							<option value="1">Jantar</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="principal">Principal:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="principal" name="principal">
						<span class="erro" id="principal-erro"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="vegetariano">Vegetariano:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="vegetariano" name="vegetariano">
						<span class="erro" id="vegetariano-erro"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="acompanhamento">Acompanhamento:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="acompanhamento" name="acompanhamento">
						<span class="erro" id="acompanhamento-erro"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="guarnicao">Guarnicao:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="guarnicao" name="guarnicao">
						<span class="erro" id="guarnicao-erro"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="sobremesa">Sobremesa:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="sobremesa" name="sobremesa">
						<span class="erro" id="sobremesa-erro"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="suco">Suco:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="suco" name="suco">
						<span class="erro" id="suco-erro"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="fruta">Fruta:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="fruta" name="fruta">
						<span class="erro" id="fruta-erro"></span>
					</div>
				</div>

				<button class="btn btn-success col-sm-offset-3 col-sm-9" type="submit">Cadastrar</button>

			</form>

			<c:if test="${ not empty feedback_cardapio }">
				<div class="erro">
					<hr>
					<span>${ feedback_cardapio }</span>
				</div>
			</c:if>

		</div>

	</div>
</body>
</html>
