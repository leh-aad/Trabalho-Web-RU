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
      <li class="active"><a href="administrador/index">Principal</a></li>
      <li><a href="cadastrar-aluno-form">Cadastrar Aluno</a></li>
      <li><a href="cadastrar-secretario-form">Cadastrar Secretario</a></li>
      <li><a href="cadastrar-cardapio-form">Cadastrar Cardapio</a></li>
      <li><a href="logout">Sair</a></li>
    </ul>
  </div>

	<jsp:include page="../rodape.jsp"></jsp:include>

</body>
</html>
