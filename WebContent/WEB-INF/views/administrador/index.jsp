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
      <li class="active"><a href="#">Principal</a></li>
      <li><a href="cadastrar-aluno-form">Cadastrar Aluno</a></li>
      <li><a href="cadastrar-secretario-form">Cadastrar Secretario</a></li>
      <li><a href="cadastrar-cardapio-form">Cadastrar Cardapio</a></li>
      <li><a href="logout">Sair</a></li>
    </ul>
  </div>

	<div class="container">

	  <div class="col-md-8 col-md-offset-2">
			<jsp:include page="../aluno/lista.jsp"/>
		</div>

		<div class="col-md-8 col-md-offset-2">
			<jsp:include page="../secretario/lista.jsp"/>
		</div>

	</div>

	<jsp:include page="../rodape.jsp"/>

</body>
</html>
