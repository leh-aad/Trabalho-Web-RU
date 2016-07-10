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
      <li><a href="/Trabalho_Web_-_RU">Principal</a></li>
      <li class="active"><a href="#">Cardapio do Proximo Dia</a></li>
      <li><a href="about">Sobre</a></li>
    </ul>
  </div>

  <div class="container">

    <div class="col-md-8">
      <jsp:include page="cardapio/cardapio.jsp"/>
    </div>

    <div class="col-md-4">
      <div class="login-form">
        <form id="form-login" action="tentativaLogin" method="post">
          <div class="form-group">
            <label for="login">Usuario:</label>
            <input class="form-control" id="login" type="text" name="login"/>
          </div>
          <div class="form-group">
            <label for="senha">Senha:</label>
            <input class="form-control" id="senha" type="password" name="senha"/>
          </div>
          <div class="form-group">
            <label for="tipo-usuario">Tipo de Usuario:</label>
            <select id="tipo-usuario" class="form-control" name="tipo_usuario">
              <option value="aluno">aluno</option>
              <option value="secretario">secretario</option>
            </select>
          </div>
          <button class="btn btn-success btn-block" type="submit">Login</button>
        </form>
      </div>
      <div class="erro">
        <hr>
        <span id="erro-login"></span>
      </div>
    </div>

  </div>
</body>
</html>
