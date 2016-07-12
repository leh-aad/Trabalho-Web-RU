<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css"/>
  <link type="text/css" rel="stylesheet" href="resources/css/main.css"/>

  <title>Tickets RU - UFC</title>
</head>
<body>
  <div class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
      <span class="navbar-brand">Tickets RU</span>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="#">Principal</a></li>
      <li><a href="aluno-next-cardapio">Cardapio do Proximo Dia</a></li>
      <li><a href="about">Sobre</a></li>
      <li><a href="logout">Sair</a></li>
    </ul>
  </div>

  <div class="container">

    <div class="col-md-9 col-md-offset-0">
      <jsp:include page="../cardapio/cardapio.jsp"/>
    </div>

    <div class="perfil col-md-3 col-md-offset-9">
      <h4 class="text-danger">Seus Dados</h4>
      <h5 class="text-success">Matricula: ${ aluno.matricula }</h5>
      <h5 class="text-success">Nome: ${ aluno.nome }</h5>
      <h5 class="text-success">Curso: ${ aluno.curso }</h5>
      <h5 class="text-success">Creditos: ${ aluno.credito }</h5>
    </div>

  </div>

  <jsp:include page="../rodape.jsp"/>

</body>
</html>
